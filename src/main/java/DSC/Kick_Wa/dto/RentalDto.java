package DSC.Kick_Wa.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class RentalDto {

    private Long userId;

    private Long vehicleId;

    public RentalDto(Long userId, Long vehicleId){
        this.userId = userId;
        this.vehicleId = vehicleId;
    }
}
