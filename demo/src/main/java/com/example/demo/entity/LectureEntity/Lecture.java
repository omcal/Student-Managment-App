package com.example.demo.entity.LectureEntity;


import com.example.demo.entity.Enums.LectureType;
import com.example.demo.entity.MemberEntity.Member;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Lecture")
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Lecture_sequence")
    @SequenceGenerator(name = "Lecture_sequence", allocationSize = 1)
    @Column(name = "lecture_id", nullable = false)
    private Long lecture_id;

    private  String title;

    private  String content;

    private Date date;

    @Enumerated(EnumType.STRING)
    private LectureType lectureType;
    @ManyToOne
    @JoinColumn(name = "lecture_post_id",referencedColumnName = "member_id",insertable = false, updatable = false)
    @JsonIgnore
    private Member member;

    @ManyToOne
    @JoinColumn(name = "lecture_date_id")
    private LectureDate lectureDate;
    private  Long lecture_post_id;

    public Lecture(String title, String content, LectureType lectureType, Long lecture_post_id) {
        this.title = title;
        this.content = content;
        this.date = new Date();
        this.lectureType = lectureType;
        this.lecture_post_id = lecture_post_id;
    }
}
