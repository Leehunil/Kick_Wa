package DSC.Kick_Wa.dto.response;

import DSC.Kick_Wa.domain.Record;
import lombok.Getter;


@Getter
public class PaymentDto {

    private Long id;
    private Long driveTime;
    private Long useFee;

    public PaymentDto(Record record){
        id = record.getVehicle().getId();
        driveTime = record.driveTime(record.getEndT());
        useFee = record.getUseFee();
    }
}
