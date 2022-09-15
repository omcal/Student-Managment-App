package com.example.demo.controller.LectureController;


import com.example.demo.dto.LecturePostingRequest;
import com.example.demo.entity.LectureEntity.Lecture;
import com.example.demo.service.Lecture.AddLectureService;

import com.example.demo.service.Lecture.LectureService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@Validated
// TODO a gui
public class LectureController {
    private final AddLectureService addLectureService;
    private final LectureService lectureService;
    @PostMapping(path = "/lecture/add",consumes = "application/json")
    public  String addNewLecture(@Valid @RequestBody LecturePostingRequest request ){
        return addLectureService.addNewLecture(request);
    }
    @GetMapping("/lecture/all")
    public List<Lecture> getAllLecture(){
        return lectureService.getAllLectureService();
    }

}
