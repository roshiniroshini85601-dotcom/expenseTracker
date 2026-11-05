package com.roshini.task1.Controller;

import com.roshini.task1.Dto.RequestDto;
import com.roshini.task1.Dto.ResponseDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.roshini.task1.Service.UserService;
@RestController
public class UserController {
    private  final UserService userService;

    public UserController(UserService userService){
       this.userService=userService;
    }

    @PostMapping("/register")
    public ResponseDto register(@RequestBody RequestDto dto) {
        return userService.register(dto);
    }
    @PostMapping("/login")
    public String login(@RequestBody RequestDto dto) {
        return userService.login(dto);
    }

}
