package DSC.Kick_Wa.dto;

import lombok.Getter;


@Getter
public class RentalDto {

    private String uid;

    private Long vehicleId;

    public RentalDto(String uid, Long vehicleId){
        this.uid = uid;
        this.vehicleId = vehicleId;
    }

    public RentalDto(){}
}
