package DSC.Kick_Wa.controller;

import DSC.Kick_Wa.config.JwtTokenProvider;
import DSC.Kick_Wa.domain.user.User;
import DSC.Kick_Wa.dto.SignInDto;
import DSC.Kick_Wa.dto.SignUpDto;
import DSC.Kick_Wa.dto.response.MyInfoDto;
import DSC.Kick_Wa.response.DefaultRes;
import DSC.Kick_Wa.response.StatusCode;
import DSC.Kick_Wa.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    //아이디 중복 확인
    @GetMapping("/checkunique")
    public ResponseEntity checkUid(@RequestParam(name = "uid") String uid){
        Boolean result = userService.checkUnique(uid);

        return result ?
                new ResponseEntity(DefaultRes.res(StatusCode.OK,"사용 가능한 아이디입니다."), HttpStatus.OK):
                new ResponseEntity(DefaultRes.res(StatusCode.BAD_REQUEST,"중복된 아이디 입니다."),HttpStatus.OK);
    }

    //회원가입 요청
    @PostMapping("/signup")
    public ResponseEntity signUp(@RequestBody SignUpDto user){
        Long result = userService.signUp(user);

        return result != null ?
                new ResponseEntity(DefaultRes.res(StatusCode.OK,"회원가입 성공 하였습니다."), HttpStatus.OK):
                new ResponseEntity(DefaultRes.res(StatusCode.BAD_REQUEST,"잘못된 요청입니다."),HttpStatus.OK);
    }

    //로그인 요청
    @PostMapping("/signin")
    public ResponseEntity signIn(@RequestBody SignInDto user, HttpServletResponse response){

        Optional<User> member = userService.findUserByUid(user.getUid());

        if(member.isEmpty()) return new ResponseEntity(DefaultRes.res(StatusCode.BAD_REQUEST,"로그인 아이디 또는 비밀번호 오류입니다"), HttpStatus.BAD_REQUEST);

        boolean checkPassword = userService.checkPassword(user,member.get());

        if(!checkPassword) return new ResponseEntity(DefaultRes.res(StatusCode.BAD_REQUEST,"로그인 아이디 또는 비밀번호 오류입니다"), HttpStatus.BAD_REQUEST);

        //액세스, 리프레시 토큰 발급 및 헤더 설정
        String accessToken = jwtTokenProvider.createAccessToken(member.get().getUid());
        String refreshToken = jwtTokenProvider.createRefreshToken(member.get().getUid());

        jwtTokenProvider.setHeaderAccessToken(response, accessToken);
        jwtTokenProvider.setHeaderRefreshToken(response, refreshToken);

        //리프레시 토큰 저장소에 저장
        userService.signIn(refreshToken, member.get());

        return new ResponseEntity(DefaultRes.res(StatusCode.OK, "로그인 완료"), HttpStatus.OK);
    }

    //로그아웃
    @PostMapping("/signout")
    public ResponseEntity signOut(@RequestHeader("RefreshToken") String refreshToken, @RequestParam(name = "userUid") String userUid){
        refreshToken = refreshToken.substring(7);
        User member = userService.findUserByUid(userUid).get();
        Boolean existAndOut = userService.signOut(refreshToken, member);

        return existAndOut ?
                new ResponseEntity(DefaultRes.res(StatusCode.OK,"로그아웃 완료"), HttpStatus.OK):
                new ResponseEntity(DefaultRes.res(StatusCode.BAD_REQUEST,"잘못된 요청입니다."),HttpStatus.OK);
    }

    //내 정보 조회
    @GetMapping("/myinfo")
    public ResponseEntity myInfo(@RequestParam(name = "uid") String uid) {
        MyInfoDto myInfoDto = userService.myInfoDto(uid);

        return myInfoDto != null ?
                new ResponseEntity(DefaultRes.res(StatusCode.OK,"나의 정보 확인 완료"), HttpStatus.OK):
                new ResponseEntity(DefaultRes.res(StatusCode.BAD_REQUEST,"잘못된 요청입니다."),HttpStatus.OK);
    }

    // 통합 예외 핸들러
    @ExceptionHandler
    public String exceptionHandler(Exception exception){
        return exception.getMessage();
    }
}
