package DSC.Kick_Wa.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class VehicleRepositorySupport {

    private final EntityManager em;

}
