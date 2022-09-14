package com.example.demo.controller.BasicController;

import com.example.demo.dto.RegistrationRequest;
import com.example.demo.service.LoginRegister.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(method = RequestMethod.POST,path = "/registration",consumes = "application/json")
@AllArgsConstructor

//TODO gui
public class RegistController {
    private final RegistrationService registrationService;
    @PostMapping
    public String register(@RequestBody RegistrationRequest request ){
        return registrationService.register(request);
    }
}
