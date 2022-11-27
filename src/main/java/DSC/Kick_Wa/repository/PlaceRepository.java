package DSC.Kick_Wa.repository;

import DSC.Kick_Wa.domain.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PlaceRepository extends JpaRepository<Place,Long> {
    Place save(Place place);
    Optional<Place> findById(Long id);

    @Query("select p from Place p left join fetch p.vehicles v where p.id = :placeId")
    Optional<Place> findByPlaceId(@Param("placeId") Long placeId);
}
