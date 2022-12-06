package DSC.Kick_Wa.repository;

import DSC.Kick_Wa.domain.Record;
import DSC.Kick_Wa.domain.user.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface RecordRepository extends JpaRepository<Record,Long> {
    Record save(Record record);
    Optional<Record> findById(Long id);

    @Transactional
    void deleteById(Long id);

    @Query("select r from Record r join fetch r.vehicle v join fetch r.user u " +
            "where u.uid = :uid")
    List<Record> findByUserId(@Param("uid") String uid);

    @Query("select distinct r from Record r join fetch r.vehicle v join fetch r.user u " +
            "where u.uid = :uid and u.userStatus = :userStatus " +
            "order by r.startT")
    List<Record> findByUserIdAndUserStatus(@Param("uid") String uid, @Param("userStatus") UserStatus userStatus);
}
