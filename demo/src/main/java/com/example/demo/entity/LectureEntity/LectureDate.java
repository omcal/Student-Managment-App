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

    @Max(value = 52)
    @Min(value = 1)
    private int numberOfWeek;
    @Max(5)
    @Min(1)
    private int numberOfDays;
    @Max(8)
    @Max(1)
    private int numberOfSlot;


}
