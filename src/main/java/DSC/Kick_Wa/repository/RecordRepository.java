package DSC.Kick_Wa.repository;

import DSC.Kick_Wa.domain.Record;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class RecordRepository {

    @PersistenceContext
    private EntityManager em;

    public Record save(Record record){
        em.persist(record);
        return record;
    }

    public Record findOne(Long id){
        return em.find(Record.class,id);
    }

}
