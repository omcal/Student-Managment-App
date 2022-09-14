package com.example.demo.service.Lecture;


import com.example.demo.dto.LecturePostingRequest;
import com.example.demo.entity.LectureEntity.Lecture;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

// a service to add Announcement
@Service
@AllArgsConstructor
public class AddLectureService {

    private final LectureService lectureService;

    public  String registerAnno(LecturePostingRequest request){
        return lectureService.addLecture(new Lecture(request.getTitle(),request.getContent(),request.getLectureType(),request.getAnno_poster_id()));
    }

}
