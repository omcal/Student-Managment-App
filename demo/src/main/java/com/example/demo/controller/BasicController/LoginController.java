package com.example.demo.controller.BasicController;

import com.example.demo.dto.LoginRequest;
import com.example.demo.service.LoginRegister.LoginService;
import com.example.demo.service.Member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private final LoginService loginService;



    @GetMapping("/")
    public ModelAndView mainPage(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("main");
        return modelAndView;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest){
        return loginService.login(loginRequest);

    }

    public LoginController(MemberService memberService, LoginService loginService) {
        this.memberService = memberService;
        this.loginService = loginService;
    }



}
