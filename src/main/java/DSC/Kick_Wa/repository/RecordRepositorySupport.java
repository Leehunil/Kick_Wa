//package DSC.Kick_Wa.repository;
//
//import DSC.Kick_Wa.domain.Record;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//import java.util.List;
//
//@Repository
//@RequiredArgsConstructor
//public class RecordRepositorySupport {
//
//    private final EntityManager em;
//
//    public List<Record> findUserUsage(Long userId){
//        return em.createQuery("select r from Record r" +
//                        " left join fetch r.vehicle v" +
//                        " left join fetch r.user u" +
//                        " where u.id = :userId", Record.class)
//                .setParameter("userId",userId)
//                .getResultList();
//    }
//
//    public List<Record> findUserInfo(Long userId){
//        return em.createQuery("select r from Record r" +
//                        " left join fetch r.user u" +
//                        " where u.id = :userId", Record.class)
//                .setParameter("userId",userId)
//                .getResultList();
//    }
//
//
//}
