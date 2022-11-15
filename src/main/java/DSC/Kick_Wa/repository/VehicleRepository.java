package DSC.Kick_Wa.repository;

import DSC.Kick_Wa.domain.Vehicle;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class VehicleRepository {

    private final EntityManager em;

    public Long save(Vehicle vehicle){
        em.persist(vehicle);
        return vehicle.getId();
    }

    public Vehicle findOne(Long id){
        return em.find(Vehicle.class,id);
    }

    public void delete(Vehicle vehicle){
        em.remove(vehicle);
    }



}
