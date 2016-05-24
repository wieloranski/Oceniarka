package oceniarka.mappers;

import oceniarka.Domain.Authority;
import oceniarka.Domain.User;

import java.util.List;

/**
 * Created by eryk on 27.10.15.
 */
public interface UserMapper {

    List<User> getAllUsers();

    User findUserByUsername(String username);

    void addUser(User user);

    void addAuthority(Authority authority);

}
