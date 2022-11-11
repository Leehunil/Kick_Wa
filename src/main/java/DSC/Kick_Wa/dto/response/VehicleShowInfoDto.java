package DSC.Kick_Wa.dto.response;

import DSC.Kick_Wa.domain.VehicleStatus;
import com.querydsl.core.annotations.QueryProjection;
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

    @QueryProjection
    public VehicleShowInfoDto(){

    }
}
