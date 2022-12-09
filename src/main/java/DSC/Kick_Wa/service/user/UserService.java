package DSC.Kick_Wa.service.user;

import DSC.Kick_Wa.domain.user.RefreshToken;
import DSC.Kick_Wa.domain.user.User;
import DSC.Kick_Wa.dto.SignInDto;
import DSC.Kick_Wa.dto.SignUpDto;
import DSC.Kick_Wa.dto.response.MyInfoDto;
import DSC.Kick_Wa.filter.CustomAuthenticationEntryPoint;
import DSC.Kick_Wa.repository.User.RefreshTokenRepository;
import DSC.Kick_Wa.repository.User.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final RefreshTokenRepository refreshTokenRepository;
    private final Logger logger = LoggerFactory.getLogger(CustomAuthenticationEntryPoint.class);
    private final PasswordEncoder passwordEncoder;

    //회원가입
    @Transactional
    public Long signUp(SignUpDto user){
        Long id = userRepository.save(
                User.builder()
                        .uid(user.getUid())
                        .password(passwordEncoder.encode(user.getPassword()))
                        .name(user.getName())
                        .phoneNum(user.getPhoneNum())
                        .email(user.getEmail())
                        .build())
                .getId();
        return id;
    }

    //로그인
    @Transactional
    public Boolean signIn (String refreshToken, User user){
        refreshTokenRepository.save(new RefreshToken(refreshToken));
        logger.info(user.getUid() + "(id : " + user.getId() + ") login");
        return true;
    }

    //로그아웃
    @Transactional
    public Boolean signOut(String refreshToken, User user) {
        if(!refreshTokenRepository.existsByRefreshToken(refreshToken)){
            return false;
        }

        refreshTokenRepository.deleteByRefreshToken(refreshToken);

        logger.info(user.getUid() + " (id : " + user.getId() + ") logout");
        return true;
    }

    //아이디 중복
    @Transactional
    public Boolean checkUnique(String uid){
        Boolean result = userRepository.existsByUid(uid);
        return !result;
    }

    //로그인 확인
    @Transactional
    public Optional<User> findUserByUidAndPassword(String uid, String password){
        String encodedPassword = passwordEncoder.encode(password);
        Optional<User> member = userRepository.findByUidAndPassword(uid, encodedPassword);

        return member;
    }

    //유저 확인
    @Transactional
    public Optional<User> findUserByUid(String uid){
        Optional<User> member = userRepository.findByUid(uid);
        return member;
    }

    // 비밀번호 확인
    @Transactional
    public boolean checkPassword(SignInDto user, User member){
        return passwordEncoder.matches(user.getPassword(), member.getPassword());
    }

    //내 정보 조회
    public MyInfoDto showMyInfo(String uid){
        User member = userRepository.findByUid(uid).get();

        MyInfoDto myInfoDto = new MyInfoDto(member);
        return myInfoDto;
    }
}
