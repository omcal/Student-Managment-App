package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// we need this for wrap the class
@Getter
@Setter
@AllArgsConstructor

public class HWPostingRequest {
    private  String title;

    private  String content;

    private String final_date;

    private String Link;

    private Long poster_id;
}
