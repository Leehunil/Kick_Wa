package DSC.Kick_Wa.servicetest;

import DSC.Kick_Wa.domain.Place;
import DSC.Kick_Wa.service.VehicleService;
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
public class VehicleTest {

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private EntityManager em;

    @Test
    public void 킥보드_생성(){

        //given
        Place place1 = new Place();
        Place place2 = new Place();
        Place place3 = new Place();
        Place place4 = new Place();

        em.persist(place1);
        em.persist(place2);
        em.persist(place3);
        em.persist(place4);

        //when
        Long vehicle1 = vehicleService.create(place1.getId(), 500, 100);
        Long vehicle2 = vehicleService.create(place2.getId(), 500, 100);
        Long vehicle3 = vehicleService.create(place3.getId(), 500, 100);
        Long vehicle4 = vehicleService.create(place4.getId(), 500, 100);
    }
}
