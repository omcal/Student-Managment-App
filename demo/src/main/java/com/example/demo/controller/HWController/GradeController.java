package com.example.demo.controller.HWController;


import com.example.demo.dto.GradePostingRequest;
import com.example.demo.entity.HWEntity.HWs;
import com.example.demo.service.HW.HWService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
class GradeController {
    private final HWService hwService;


    @PostMapping("/grade/addgrade/{id}")
    public String addGrade(@RequestBody GradePostingRequest grades, @PathVariable long id){
        boolean resultBoolean=hwService.addGrade(grades.getStudent_id(),grades.getGrade(),id);
        return resultBoolean ? "Grade has added" : "There is a mistake check grade and Student Number";
    }
    @GetMapping("/grade/hw/{id}")
    public HWs getOneHW(@PathVariable long id){
        return hwService.getOneHW(id);
    }

}
