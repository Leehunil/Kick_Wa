package DSC.Kick_Wa.repository;

import DSC.Kick_Wa.domain.Vehicle;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class VehicleRepositorySupport {

    private final EntityManager em;

}
