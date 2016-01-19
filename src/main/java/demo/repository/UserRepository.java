package demo.repository;

/**
 * Created by baljit on 19/01/2016.
 */
import demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findOneByEmail(String email);
}
