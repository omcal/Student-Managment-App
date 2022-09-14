package com.example.demo.service.Lecture;

import com.example.demo.repository.LectureRepo.LectureRepository;
import com.example.demo.entity.LectureEntity.Lecture;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class LectureService {
    private final LectureRepository lectureRepository;
    public String addLecture(Lecture lecture){
        try {
            lectureRepository.save(lecture);
        }catch (Exception e){
            return e.getMessage()+"\n Please check your inputs \n";
        }
        return "Announcement has added";
    }

    public List<Lecture> getAllLectureService(){
        return lectureRepository.findAll();
    }
}
