package DSC.Kick_Wa.repository.place;

import DSC.Kick_Wa.domain.Place;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
public class PlaceRepositorySupport extends QuerydslRepositorySupport {
    private final JPAQueryFactory jpaQueryFactory;

    public PlaceRepositorySupport(JPAQueryFactory jpaQueryFactory) {
        super(Place.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }
}
