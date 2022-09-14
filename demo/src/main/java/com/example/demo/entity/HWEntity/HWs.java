package com.example.demo.entity.HWEntity;

import com.example.demo.entity.MemberEntity.Member;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "HWs")
@AllArgsConstructor
public class HWs {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Hw_sequence")
    @SequenceGenerator(name = "Hw_sequence", allocationSize = 1)
    @Column(name = "hw_id", nullable = false)
    private Long hw_id;

    private  String title;

    private  String content;

    private String final_date;

    private String link;





    @ManyToOne
    @JoinColumn(name = "poster_id",referencedColumnName = "member_id",insertable = false, updatable = false)
    @JsonIgnore
    private Member member;

    @ElementCollection
    @MapKeyColumn(name="member_id")
    @Column(name="grades")
    @CollectionTable(name="student_id", joinColumns=@JoinColumn(name="grade_id"))
    private Map<Integer,Integer> grade=new HashMap<>();

    private  Long poster_id;
    public HWs(String title, String content, String date, String link, Long poster_id) {
        this.title = title;
        this.content = content;
        this.final_date = date;
        this.link = link;
        this.poster_id=poster_id;

    }

}
