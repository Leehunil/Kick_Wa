package DSC.Kick_Wa.dto.response;

import DSC.Kick_Wa.domain.VehicleStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class VehicleShowInfoDto {

    private LocalDateTime endT;
    private Integer baseRate;
    private Integer perMinuteRate;
    private VehicleStatus vehicleStatus;

    public VehicleShowInfoDto(){

    }
}