package com.example.demo.service.LoginRegister;

import com.example.demo.dto.RegistrationRequest;
import com.example.demo.entity.MemberEntity.Member;
import com.example.demo.security.Utils.EmailValidator;
import com.example.demo.service.Member.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {
    private EmailValidator validator;
    private final MemberService memberService;

    public String register(RegistrationRequest request) {
        if (!validator.test(request.getEmail())){
            throw new IllegalArgumentException("Please Input a Valid Email");
        }
        return memberService.signUp(new Member(request.getName(),request.getSurname(),request.getEmail(),request.getPassword(),request.getRole()));
    }

}
