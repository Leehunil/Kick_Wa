package DSC.Kick_Wa.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class RentalDto {

    private Long userId;

    private Long vehicleId;

    private LocalDateTime startT;

    public RentalDto(Long userId, Long vehicleId, LocalDateTime startT){
        this.userId = userId;
        this.vehicleId = vehicleId;
        this.startT = startT;
    }
}
