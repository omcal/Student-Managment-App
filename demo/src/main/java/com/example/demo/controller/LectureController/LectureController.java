package com.example.demo.controller.LectureController;


import com.example.demo.dto.LecturePostingRequest;
import com.example.demo.entity.LectureEntity.Lecture;
import com.example.demo.service.Lecture.AddLectureService;

import com.example.demo.service.Lecture.LectureService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
// TODO a gui
public class LectureController {
    private final AddLectureService addLectureService;
    private final LectureService lectureService;
    @PostMapping(path = "/lecture/add/lecture",consumes = "application/json")
    public  String registerAnno(@RequestBody LecturePostingRequest request ){
        return addLectureService.registerAnno(request);
    }
    @GetMapping("/lecture/all")
    public List<Lecture> getAllLecture(){
        return lectureService.getAllLectureService();
    }

}
