package DSC.Kick_Wa.dto.response;

import DSC.Kick_Wa.domain.Vehicle;
import DSC.Kick_Wa.domain.VehicleStatus;
import lombok.Getter;

@Getter
public class PlaceVehicleInfoDto {

    private Long id;
    private VehicleStatus vehicleStatus;

    public PlaceVehicleInfoDto(Vehicle vehicle){
        id = vehicle.getId();
        vehicleStatus = vehicle.getVehicleStatus();
    }
}
