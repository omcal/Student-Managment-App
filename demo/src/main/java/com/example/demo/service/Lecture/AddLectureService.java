package com.example.demo.service.Lecture;


import com.example.demo.dto.LecturePostingRequest;
import com.example.demo.entity.LectureEntity.Lecture;
import com.example.demo.entity.LectureEntity.LectureDate;
import com.example.demo.repository.LectureRepo.LectureDateRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

// a service to add Announcement
@Service
@AllArgsConstructor
public class AddLectureService {

    private final LectureService lectureService;
    private final LectureDateRepo lectureDateRepo;

    public  String addNewLecture(LecturePostingRequest request){
        LectureDate lectureDate=request.getLectureDate();
        if (lectureDateRepo.existsLectureDateByNumberOfWeekAndAndNumberOfDaysAndAndNumberOfSlot(lectureDate.getNumberOfWeek(),
                lectureDate.getNumberOfDays(), lectureDate.getNumberOfSlot())) {
            return "Please choose other time slot ";
        }  else if (lectureDate.getNumberOfWeek()<1 || lectureDate.getNumberOfWeek()>52) {
                return "A Week should be between  1-52";
        } else if (lectureDate.getNumberOfDays()<1 || lectureDate.getNumberOfDays()>5) {
            return "A Day should be between 1-5";
        }else if (lectureDate.getNumberOfSlot()<1 || lectureDate.getNumberOfSlot()>8){
            return "A Slot should be between 1-8 ";
        }


        return lectureService.addLecture(new Lecture(request.getTitle(),request.getContent(),request.getLectureType(),request.getLecture_poster_id()),lectureDate);
    }

}
