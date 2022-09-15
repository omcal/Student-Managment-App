package com.example.demo.dto;


import com.example.demo.entity.Enums.LectureType;
import com.example.demo.entity.LectureEntity.LectureDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// we need this for wrap the class
@Getter
@Setter
@AllArgsConstructor
public class LecturePostingRequest {
    private  String title;

    private  String content;

    private LectureType lectureType;

    private LectureDate lectureDate;

    private  Long lecture_poster_id;


}
