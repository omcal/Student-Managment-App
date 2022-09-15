package com.example.demo.controller.StudentController;

import com.example.demo.service.S3.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class StudentController {
    @Autowired
    private S3Service s3Service;
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
    @PostMapping("/student/uploadhw")
    public String upload(@RequestParam("file") MultipartFile file){
        return s3Service.saveFile(file);
    }

}
