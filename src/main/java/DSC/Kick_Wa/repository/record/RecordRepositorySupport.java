package DSC.Kick_Wa.repository.record;

import DSC.Kick_Wa.domain.Record;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
public class RecordRepositorySupport extends QuerydslRepositorySupport {

    private final JPAQueryFactory jpaQueryFactory;

    public RecordRepositorySupport(JPAQueryFactory jpaQueryFactory) {
        super(Record.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }
}
