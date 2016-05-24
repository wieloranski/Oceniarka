package oceniarka.cotrollers;

import oceniarka.Domain.Authority;
import oceniarka.Domain.User;
import oceniarka.management.UserMgmt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.json.Json;
import javax.json.JsonObject;
import java.nio.charset.Charset;
import java.util.List;

/**
 * Created by nikodem on 15.11.15.
 */
@RestController
@RequestMapping("/api/session")
public class SessionController {

    private static final Logger logger = LoggerFactory.getLogger(SessionController.class);

    @Resource
    private UserMgmt userMgmt;


    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userMgmt.getAllUsers(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseEntity<String> login(@RequestBody User loginInfo) {
        String login = loginInfo.getUsername();
        String password = loginInfo.getPassword();


        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (userMgmt.findUserByUsername(login) == null ||
                !passwordEncoder.matches(password, userMgmt.findUserByUsername(login).getPassword())) {
            logger.warn("Wrong login or password");
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

        String loginString = login + ":" + password;
        byte[] encodedBytes = Base64.encode(loginString.getBytes());
        String encoded = new String(encodedBytes, Charset.forName("UTF-8"));

        JsonObject result = Json.createObjectBuilder()
                .add("status", "OK")
                .add("auth", encoded)
                .build();

        return new ResponseEntity<>(result.toString(), HttpStatus.OK);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> register(@RequestBody User user) {
        logger.info("Register method");

        if (user.getPassword() == null || user.getUsername() == null) {
            logger.warn("Username or password is null");
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        if (userMgmt.findUserByUsername(user.getUsername()) != null) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        if (user.getPassword().length() < 5) {
            logger.warn("Password too short");
            return new ResponseEntity<>("Password has to have at least 6 characters", HttpStatus.BAD_REQUEST);
        }

        Authority authority = new Authority(user.getUsername(), "USER");

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);

        userMgmt.addUser(user);
        userMgmt.addAuthority(authority);


        return new ResponseEntity(HttpStatus.CREATED);
    }


}
