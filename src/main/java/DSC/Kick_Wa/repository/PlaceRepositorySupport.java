package DSC.Kick_Wa.repository;

import DSC.Kick_Wa.domain.Place;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class PlaceRepositorySupport {

    private final EntityManager em;



}
