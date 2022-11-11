package DSC.Kick_Wa.repository.Vehicle;

import DSC.Kick_Wa.domain.Vehicle;
import DSC.Kick_Wa.dto.response.VehicleShowInfoDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VehicleRepositorySupport extends QuerydslRepositorySupport {

    private final JPAQueryFactory jpaQueryFactory;

    public VehicleRepositorySupport(JPAQueryFactory jpaQueryFactory) {
        super(Vehicle.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }


}
