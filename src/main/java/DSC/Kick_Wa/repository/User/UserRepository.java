package DSC.Kick_Wa.repository.User;

import DSC.Kick_Wa.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUid(String uid);
    User save(User user);

    boolean existsByUid(String uid);
    Optional<User> findByUidAndPassword(String uid, String password);



}
