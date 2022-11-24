package DSC.Kick_Wa.service.user;

import DSC.Kick_Wa.domain.user.User;
import DSC.Kick_Wa.domain.user.UserStatus;
import DSC.Kick_Wa.dto.SignUpDto;
import DSC.Kick_Wa.dto.response.UserRecordDto;
import DSC.Kick_Wa.repository.User.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
@RequiredArgsConstructor
//@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public Long signUp(SignUpDto user){
        Long id = userRepository.save(
                User.builder()
                        .name(user.getName())
                        .email(user.getEmail())
                        .build())
                .getId();
        return id;
    }

    //유저의 이용 정보 보여주기
    public UserRecordDto showUserInfo(Long userId){
        User user = userRepository.findById(userId).get();
        if(user.getUserStatus() == UserStatus.DRIVING){
            UserRecordDto userRecordDto = new UserRecordDto(user);
            return userRecordDto;
        }else {
            return null;
        }
    }


}
