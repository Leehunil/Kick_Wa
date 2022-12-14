package DSC.Kick_Wa;

import DSC.Kick_Wa.domain.*;
import DSC.Kick_Wa.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.time.LocalDateTime;

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
            User user1 = new User("hunil7777","hun.7777","이훈일","010-7777-7751","hunil7777@gmail.com");
            User user2 = new User("ju77777","jun777777","이정일","010-7777-3757","hunil777777@gmail.com");
            User user3 = new User("junjang44","jojo","조준장","010-1234-5678","hunil777777777@gmail.com");

            em.persist(user1);
            em.persist(user2);
            em.persist(user3);

            Place place1 = new Place("bus1","a","b");
            Place place2 = new Place("bus1","a","b");
            Place place3 = new Place("bus1","a","b");

            em.persist(place1);
            em.persist(place2);
            em.persist(place3);

            Vehicle vehicle1 = new Vehicle(place1,500,100, VehicleStatus.POSSIBLE,"ADDVUHNSDIBN13NDV");
            vehicle1.setEndT(LocalDateTime.now());
            Vehicle vehicle2 = new Vehicle(place2,500,100,VehicleStatus.POSSIBLE,"AJSGJBIO8298RBV82BDUV");
            vehicle2.setEndT(LocalDateTime.now());
            Vehicle vehicle3 = new Vehicle(place3,500,100,VehicleStatus.POSSIBLE,"UQIEGIUQ84HVUFHDBJSFSUBVFD"); 
            vehicle3.setEndT(LocalDateTime.now());

            em.persist(vehicle1);
            em.persist(vehicle2);
            em.persist(vehicle3);

            Record record1 = new Record(user1,vehicle1,LocalDateTime.now());
            Record record2 = new Record(user2,vehicle2,LocalDateTime.now());
            Record record3 = new Record(user3,vehicle3,LocalDateTime.now());

            em.persist(record1);
            em.persist(record2);
            em.persist(record3);

        }
    }
}
