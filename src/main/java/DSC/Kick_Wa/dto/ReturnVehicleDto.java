package DSC.Kick_Wa.dto;

import DSC.Kick_Wa.domain.Place;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ReturnVehicleDto {

    private Long recordId;

    private Long placeId;

    private Long vehicleId;
}
