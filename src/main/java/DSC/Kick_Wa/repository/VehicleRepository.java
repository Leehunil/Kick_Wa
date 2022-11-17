package DSC.Kick_Wa.repository;

import DSC.Kick_Wa.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle,Long> {
    Vehicle save(Vehicle vehicle);
    Optional<Vehicle> findById(Long id);

    @Transactional
    void deleteById(Long id);
}
