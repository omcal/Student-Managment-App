package com.example.demo.controller.StudentController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class StudentController {
    @GetMapping("/student")
    public String studentPage(){
        //TODO student's page gui
        return "this is student";
    }
    @GetMapping("/student/uploadhw")
    public ModelAndView uploadHwPage(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("S3.html");

        return modelAndView;
    }

}
