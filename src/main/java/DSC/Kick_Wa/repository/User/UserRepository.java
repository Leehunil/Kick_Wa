package DSC.Kick_Wa.repository.User;

import DSC.Kick_Wa.domain.Record;
import DSC.Kick_Wa.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final EntityManager em;

    public Long save(User user){
        em.persist(user);
        return user.getId();
    }

    public User findOne(Long id){
        return em.find(User.class,id);
    }
}