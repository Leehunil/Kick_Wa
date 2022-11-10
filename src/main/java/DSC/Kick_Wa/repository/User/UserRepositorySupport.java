package DSC.Kick_Wa.repository.User;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositorySupport {

    private final JPAQueryFactory jpaQueryFactory;

    public UserRepositorySupport(JPAQueryFactory jpaQueryFactory){
        this.jpaQueryFactory = jpaQueryFactory;
    }
}
