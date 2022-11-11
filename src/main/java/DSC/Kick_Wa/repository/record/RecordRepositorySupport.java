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

@Repository
public class RecordRepositorySupport extends QuerydslRepositorySupport {

    private final JPAQueryFactory jpaQueryFactory;

    public RecordRepositorySupport(JPAQueryFactory jpaQueryFactory) {
        super(Record.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Transactional
    public Long returnVehicle(ReturnVehicleDto returnVehicleDto){
        QRecord r = QRecord.record;
        return jpaQueryFactory.update(r)
                .set(r.endPlace,returnVehicleDto.getEndPlace())
                .set(r.endT, LocalDateTime.now())
                .execute();
    }
}
