package DSC.Kick_Wa.controller;

import DSC.Kick_Wa.dto.SignUpDto;
import DSC.Kick_Wa.response.DefaultRes;
import DSC.Kick_Wa.response.StatusCode;
import DSC.Kick_Wa.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/signUp")
    public ResponseEntity signUp(@RequestBody SignUpDto user){
        Long result = userService.signUp(user);

        return result != null ?
                new ResponseEntity(DefaultRes.res(StatusCode.OK, "회원가입 요청을 성공하였습니다", result), HttpStatus.OK) :
                new ResponseEntity(DefaultRes.res(StatusCode.BAD_REQUEST, "잘못된 요청"), HttpStatus.OK);

    }
}
