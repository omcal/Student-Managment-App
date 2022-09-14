package com.example.demo.repository.LectureRepo;

import com.example.demo.entity.LectureEntity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)

public interface LectureRepository extends JpaRepository <Lecture,Long>{
    List<Lecture> findAll();

}
