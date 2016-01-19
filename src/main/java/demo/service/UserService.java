package demo.service;

/**
 * Created by baljit on 19/01/2016.
 */
import demo.domain.User;

import java.util.Collection;
import java.util.Optional;

public interface UserService {

    Optional<User> getUserById(long id);

    Optional<User> getUserByEmail(String email);

    Collection<User> getAllUsers();

    //User create(UserCreateForm form);

}
