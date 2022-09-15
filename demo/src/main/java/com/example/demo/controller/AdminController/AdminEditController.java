package com.example.demo.controller.AdminController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.repository.MemberRepo.MemberRepository;
import com.example.demo.entity.MemberEntity.Member;
import com.example.demo.service.Member.AdminService;
import com.example.demo.service.Member.MemberService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/admin/edit")
@AllArgsConstructor
public class AdminEditController {

    @Autowired
    MemberRepository memberRepository;
    MemberService memberService;
    AdminService adminService;

    @GetMapping("/list")
    public List<Member> get() {
        return memberRepository.findAll();
    }

    @GetMapping("/activelist")
    public List<Member> getActiveList(){
        return adminService.getActiveList();
    }
    @GetMapping("/activestudent")
    public List<Member> getActiveStudents(){
        return adminService.getActiveStudentList();
    }

    @PostMapping("/adduser")
    public String addMember(@RequestBody Member member) {
        return memberService.signUp(member);
    }

    @PutMapping("/updateuser")
    public ResponseEntity<String> updateMember(@RequestBody Member member) {
        return new ResponseEntity<>(adminService.updateUser(member),HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    @JsonIgnore
    public ResponseEntity<Member> getMember(@PathVariable long id) {
        Optional<Member> member = memberRepository.findById(id);
       try{
           if (member.isPresent()) {
               return  new ResponseEntity<Member>(member.get(), HttpStatus.OK);
           } else {
               throw new RuntimeException("Member not found for the id " + id);
           }
       }catch (Exception e){
           System.out.println(e.getMessage());
           return  new ResponseEntity<Member>((Member) null, HttpStatus.NOT_FOUND);
       }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMember(@PathVariable long id){
        Optional<Member> member = memberRepository.findById(id);
       try{
           if(member.isPresent()) {
               memberRepository.delete(member.get());
               return new ResponseEntity<String >("Member is deleted with id "+id,HttpStatus.OK);
           }else {
               throw new RuntimeException("Member not found for the id "+id);
           }
       }catch (Exception e){
           return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
       }
    }
}
