package DSC.Kick_Wa.repository.User;

import DSC.Kick_Wa.domain.user.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

    boolean existsByRefreshToken(String token);

    @Transactional
    void deleteByRefreshToken(String token);
}
