//package DSC.Kick_Wa.controller;
//
//import DSC.Kick_Wa.response.DefaultRes;
//import DSC.Kick_Wa.response.StatusCode;
//import DSC.Kick_Wa.service.user.CustomOAuth2UserService;
//import DSC.Kick_Wa.service.user.UserService;
//import lombok.AllArgsConstructor;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//@AllArgsConstructor
//public class UserController {
//
//    private final CustomOAuth2UserService customOAuth2UserService;
//    private final UserService userService;
//
//    @PostMapping("/login")
//    public ResponseEntity signUp(@RequestBody OAuth2UserRequest userRequest){
//        OAuth2User oAuth2User = customOAuth2UserService.loadUser(userRequest);
//
//        return oAuth2User != null ?
//                new ResponseEntity(DefaultRes.res(StatusCode.OK, "회원가입 요청을 성공하였습니다", oAuth2User), HttpStatus.OK) :
//                new ResponseEntity(DefaultRes.res(StatusCode.BAD_REQUEST, "잘못된 요청"), HttpStatus.OK);
//    }
//
//    @GetMapping("/")
//    public String index(){
//        return "index"
//    }
//}
