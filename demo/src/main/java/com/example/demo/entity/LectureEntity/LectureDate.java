package com.example.demo.entity.LectureEntity;

import com.example.demo.entity.HWEntity.HWs;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class LectureDate {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Lecture_sequence")
    @Column(name = "id", nullable = false)
    private Long id;
    private int numberOfWeek;
    private int numberOfDays;
    private int numberOfSlot;


}
