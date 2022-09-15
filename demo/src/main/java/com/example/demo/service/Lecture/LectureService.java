package com.example.demo.service.Lecture;

import com.example.demo.entity.LectureEntity.LectureDate;
import com.example.demo.repository.LectureRepo.LectureDateRepo;
import com.example.demo.repository.LectureRepo.LectureRepository;
import com.example.demo.entity.LectureEntity.Lecture;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
@AllArgsConstructor

public class LectureService {
    private final LectureRepository lectureRepository;
    private final LectureDateRepo lectureDateRepo;
    public String addLecture(@Valid Lecture lecture, LectureDate lectureDate){
        try {
            lecture.setLectureDate(lectureDate);
            lectureDateRepo.save(lectureDate);
            lectureRepository.save(lecture);
        }catch (Exception e){
            return "Please check your inputs \n";
        }
        return "Lecture has added";
    }

    public List<Lecture> getAllLectureService(){
        return lectureRepository.findAll();
    }
}
