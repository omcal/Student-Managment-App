package com.example.demo.repository.LectureRepo;

import com.example.demo.entity.LectureEntity.LectureDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LectureDateRepo extends JpaRepository<LectureDate,Long> {


    @Query("""
            select (count(l) > 0) from LectureDate l
            where l.numberOfWeek = ?1 and l.numberOfDays = ?2 and l.numberOfSlot = ?3""")
    boolean existsLectureDateByNumberOfWeekAndAndNumberOfDaysAndAndNumberOfSlot(int numberOfWeek,int numberOfDays,int numberOfSlots);
}
