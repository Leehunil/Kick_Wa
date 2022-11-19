package DSC.Kick_Wa.service.user;

import DSC.Kick_Wa.domain.User;
import DSC.Kick_Wa.dto.SignUpDto;
import DSC.Kick_Wa.repository.User.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public Long signUp(SignUpDto user){
        Long id = userRepository.save(
                User.builder()
                        .name(user.getName())
                        .address(user.getAddress())
                        .phoneNum(user.getPhoneNum())
                        .loginId(user.getLoginId())
                        .password(user.getPassword())
                        .email(user.getEmail())
                        .build())
                .getId();
        return id;
    }
}
