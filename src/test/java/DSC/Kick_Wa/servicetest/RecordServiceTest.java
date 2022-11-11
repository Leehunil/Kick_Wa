package DSC.Kick_Wa.servicetest;

import DSC.Kick_Wa.domain.Place;
import DSC.Kick_Wa.domain.User;
import DSC.Kick_Wa.domain.Vehicle;
import DSC.Kick_Wa.service.RecordService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Transactional
@Rollback(value = false)
public class RecordServiceTest {

    @Autowired
    private RecordService recordService;

    @Autowired
    private EntityManager em;

    @Test
    public void 킥보드_대여(){
        //given
        User user1 = new User();
        User user2 = new User();

        Vehicle vehicle = new Vehicle();

        em.persist(user1);
        em.persist(user2);

        em.persist(vehicle);
        recordService.rental(user1.getId(), vehicle.getId());
    }
}
