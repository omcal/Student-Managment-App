package com.example.demo.controller.AdminController;

import com.example.demo.repository.MemberRepo.MemberRepository;
import com.example.demo.service.Member.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class AdminController {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    AdminService adminService;
    @GetMapping("/admin")
    public String adminPage(){
        //TODO admin's page gui
        return "this is admin";
    }
    @GetMapping("/admin/db")
    public ResponseEntity<Object> adminManagePage(){
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create("http://localhost:8081"))
                .build();
    }
    @PostMapping("/admin/deactivate/{id}")
    public String deactivateStudent(@PathVariable Long id){

        return  adminService.deactivateStudent(id);

    }

}
