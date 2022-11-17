package DSC.Kick_Wa.dto;

import lombok.Getter;


@Getter
public class RentalDto {

    private Long userId;

    private Long vehicleId;

    public RentalDto(Long userId, Long vehicleId){
        this.userId = userId;
        this.vehicleId = vehicleId;
    }
}
