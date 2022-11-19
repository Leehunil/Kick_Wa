package DSC.Kick_Wa.repository.User;

import DSC.Kick_Wa.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    User save(User user);
    Optional<User> findById(Long id);


}
