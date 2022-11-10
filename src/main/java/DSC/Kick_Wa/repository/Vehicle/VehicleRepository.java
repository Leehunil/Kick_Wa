package DSC.Kick_Wa.repository.Vehicle;

import DSC.Kick_Wa.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle,Long> {

    Vehicle save(Vehicle vehicle);
    Optional<Vehicle> findById(Long id);
    List<Vehicle> findAll();

    @Transactional
    void deleteById(Long id);
}
