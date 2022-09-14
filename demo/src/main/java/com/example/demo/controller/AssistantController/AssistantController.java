package com.example.demo.controller.AssistantController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AssistantController {

    @GetMapping("/assistant")
    public String graduatePage(){
        //TODO graduate's page gui
        return "this is graduate";
    }

}
