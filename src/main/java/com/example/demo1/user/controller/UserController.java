package com.example.demo1.user.controller;

import com.example.demo1.user.dto.UserDto;
import com.example.demo1.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public String root(){
        return "redirect:/login";
    }
    @GetMapping("/login")
    public String login(){
        return "userLogin";
    }
    @GetMapping("/access_denied")
    public String denied(){
        return "userLogin";
    }
    @GetMapping("/signUp")
    public String signUpForm(){
        return "userSignup";
    }
    @PostMapping("/signUp")
    public String signUp(UserDto userDto){
        userService.joinUser(userDto);
        return "redirect:/login";
    }
    @GetMapping("/user_access")
    public String userAccess(Model model, Authentication authentication) {
        UserDto userDto = (UserDto) authentication.getPrincipal();
        model.addAttribute("info", userDto.getUserId() +"의 "+ userDto.getUserName()+ "님");      //유저 아이디
        return "redirect:/board";
    }
}