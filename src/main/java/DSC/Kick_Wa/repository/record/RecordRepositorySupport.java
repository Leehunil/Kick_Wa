package DSC.Kick_Wa.repository.record;

import DSC.Kick_Wa.domain.QRecord;
import DSC.Kick_Wa.domain.QVehicle;
import DSC.Kick_Wa.domain.Record;
import DSC.Kick_Wa.dto.ReturnVehicleDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Repository
public class RecordRepositorySupport extends QuerydslRepositorySupport {

    private final JPAQueryFactory jpaQueryFactory;

    public RecordRepositorySupport(JPAQueryFactory jpaQueryFactory) {
        super(Record.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Transactional
    public Long returnVehicle(Long placeId) {
        QRecord record = QRecord.record;
        return jpaQueryFactory.update(record)
                .set(record.endPlace, placeId)
                .set(record.endT, LocalTime.now())
                .execute();
    }
}
