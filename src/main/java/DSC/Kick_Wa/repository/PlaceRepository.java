package DSC.Kick_Wa.repository;

import DSC.Kick_Wa.domain.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface PlaceRepository extends JpaRepository<Place,Long> {
    Place save(Place place);
    Optional<Place> findById(Long id);

    @Transactional
    void deleteById(Long id);
}
