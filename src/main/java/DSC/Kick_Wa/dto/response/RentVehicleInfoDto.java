package DSC.Kick_Wa.dto.response;

import DSC.Kick_Wa.domain.Record;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class RentVehicleInfoDto {

    private String name;
    private Long id;
    private Integer baseRate;
    private Integer perMinuteRate;
    private LocalDateTime startT;

    public RentVehicleInfoDto(Record record){
        name = record.getUser().getName();
        id=record.getVehicle().getId();
        baseRate = record.getVehicle().getBaseRate();
        perMinuteRate = record.getVehicle().getPerMinuteRate();
        startT = record.getStartT();
    }

}
