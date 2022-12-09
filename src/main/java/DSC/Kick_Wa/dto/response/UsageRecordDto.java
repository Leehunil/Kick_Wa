package DSC.Kick_Wa.dto.response;

import DSC.Kick_Wa.domain.Record;
import lombok.Getter;
import java.time.LocalDateTime;


@Getter
public class UsageRecordDto {

    private LocalDateTime endT;

    private Long useFee;


    public UsageRecordDto(Record record) {
        endT = record.getEndT();
        useFee = record.getUseFee();
    }
}
