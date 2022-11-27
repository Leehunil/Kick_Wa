package DSC.Kick_Wa.dto.response;

import DSC.Kick_Wa.domain.Vehicle;
import DSC.Kick_Wa.domain.VehicleStatus;
import lombok.Getter;

@Getter
public class PlaceVehicleInfo {

    private Long id;
    private VehicleStatus vehicleStatus;

    public PlaceVehicleInfo(Vehicle vehicle){
        id = vehicle.getId();
        vehicleStatus = vehicle.getVehicleStatus();
    }
}
