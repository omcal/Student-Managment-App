package com.example.demo.controller.AcademicianController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AcademicianController {

    @GetMapping("/academician")
    public String academicianPage(){
        //TODO academician's page gui

        return "this is academician";
    }

}
