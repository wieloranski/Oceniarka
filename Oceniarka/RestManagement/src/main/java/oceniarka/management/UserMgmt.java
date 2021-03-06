package oceniarka.management;

import oceniarka.Domain.Authority;
import oceniarka.Domain.User;
import oceniarka.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by nikodem on 29.11.15.
 */
@Component
public class UserMgmt {

    @Autowired
    public UserMapper userMapper;

    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }

    public User findUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }

    public void addUser(User user) {
        user.setCreateTime(new Date());
        userMapper.addUser(user);
    }

    public void addUserWithCustomDate(User user) {
        userMapper.addUser(user);

    }

    public void addAuthority(Authority authority) {
        userMapper.addAuthority(authority);
    }

}
