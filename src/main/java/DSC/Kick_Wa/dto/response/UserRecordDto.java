package DSC.Kick_Wa.dto.response;

import DSC.Kick_Wa.domain.user.User;
import DSC.Kick_Wa.domain.user.UserStatus;
import lombok.Getter;

@Getter
public class UserRecordDto {

    private String name;

    private Integer useCount;

    private UserStatus userStatus;

    public UserRecordDto(User user){
        this.name = user.getName();
        this.useCount = user.getUseCount();
        this.userStatus = user.getUserStatus();
    }
}
