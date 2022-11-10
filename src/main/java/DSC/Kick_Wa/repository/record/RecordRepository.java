package DSC.Kick_Wa.repository.record;

import DSC.Kick_Wa.domain.Record;
import DSC.Kick_Wa.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RecordRepository extends JpaRepository<Record,Long> {

    Record save(Record record);
    Optional<Record> findById(Long id);
    List<Record> findAll();
}
