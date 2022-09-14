package com.example.demo.dto;


import com.example.demo.entity.Enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// we need this for wrap the class
@Getter
@Setter
@AllArgsConstructor
@ToString
public class RegistrationRequest {
    private  final  String name;
    private  final  String surname;
    private  final  String email;
    private  final  String password;
    private   Role role;
}
