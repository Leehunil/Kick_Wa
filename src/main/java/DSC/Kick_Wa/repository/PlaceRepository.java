package DSC.Kick_Wa.repository;

import DSC.Kick_Wa.domain.Place;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class PlaceRepository {

    private final EntityManager em;

    public Long save(Place place){
        em.persist(place);
        return place.getId();
    }

    public Place findOne(Long id){
        return em.find(Place.class,id);
    }

    public void delete(Place place){
        em.remove(place);
    }


}
