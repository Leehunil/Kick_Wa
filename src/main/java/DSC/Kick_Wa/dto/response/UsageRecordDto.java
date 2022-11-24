package DSC.Kick_Wa.dto.response;

import DSC.Kick_Wa.domain.Record;
import lombok.Getter;
import java.time.LocalDateTime;


@Getter
public class UsageRecordDto {

    private LocalDateTime startT;

    private LocalDateTime endT;

    private Long useFee;

    private Long vehicleId;

    private Long userId;

    public UsageRecordDto(Record record) {
        startT = record.getStartT();
        endT = record.getEndT();
        useFee = record.getUseFee();
        vehicleId = record.getVehicle().getId();
        userId = record.getUser().getId();
    }
}
