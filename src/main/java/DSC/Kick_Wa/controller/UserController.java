package DSC.Kick_Wa.controller;

import DSC.Kick_Wa.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class UserController {

    private final UserService userService;


}
