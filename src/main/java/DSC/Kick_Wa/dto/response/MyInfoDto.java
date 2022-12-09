package DSC.Kick_Wa.dto.response;

import DSC.Kick_Wa.domain.user.User;
import DSC.Kick_Wa.domain.user.UserStatus;
import lombok.Getter;

@Getter
public class MyInfoDto {

    private String name;
    private Integer useCount;
    private UserStatus userStatus;

    public MyInfoDto(User user) {
        name = user.getName();
        useCount = user.getUseCount();
        userStatus = user.getUserStatus();
    }
}
