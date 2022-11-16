package DSC.Kick_Wa;

import DSC.Kick_Wa.domain.Place;
import DSC.Kick_Wa.domain.Record;
import DSC.Kick_Wa.domain.User;
import DSC.Kick_Wa.domain.Vehicle;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void init(){
        initService.dvInit1();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService{

        private final EntityManager em;
        public void dvInit1(){
            User user1 = new User();
            User user2 = new User();
            User user3 = new User();

            em.persist(user1);
            em.persist(user2);
            em.persist(user3);

            Vehicle vehicle1 = new Vehicle();
            Vehicle vehicle2 = new Vehicle();
            Vehicle vehicle3 = new Vehicle();

            em.persist(vehicle1);
            em.persist(vehicle2);
            em.persist(vehicle3);

            Place place1 = new Place();
            Place place2 = new Place();
            Place place3 = new Place();

            em.persist(place1);
            em.persist(place2);
            em.persist(place3);

            Record record1 = new Record();
            Record record2 = new Record();
            Record record3 = new Record();

            em.persist(record1);
            em.persist(record2);
            em.persist(record3);

            JSONParser jsonParser = new JSONParser();
        }
    }
}
