package DSC.Kick_Wa.repository.place;

import DSC.Kick_Wa.domain.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlaceRepository extends JpaRepository<Place,Long> {

    Place save(Place place);
    Optional<Place> findById(Long id);
    List<Place> findAll();
}
