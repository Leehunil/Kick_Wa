package DSC.Kick_Wa.repository;

import DSC.Kick_Wa.domain.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface RecordRepository extends JpaRepository<Record,Long> {
    Record save(Record record);
    Optional<Record> findById(Long id);

    @Transactional
    void deleteById(Long id);
}
