package com.example.demo.controller.AdminController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.repository.MemberRepo.MemberRepository;
import com.example.demo.entity.MemberEntity.Member;
import com.example.demo.service.Member.AdminService;
import com.example.demo.service.Member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class AdminEditController {
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

    @PostMapping("/addorupdate")
    public String addMember(@RequestBody Member member) {
        return memberService.signUp(member);
    }

    @PutMapping("/addorupdate")
    public Member updateMember(@RequestBody Member member) {
        return memberRepository.save(member);
    }

    @GetMapping("/get/{id}")
    public Member getMember(@PathVariable long id) {
        Optional<Member> member = memberRepository.findById(id);
        if (member.isPresent()) {
            return member.get();
        } else {
            throw new RuntimeException("Member not found for the id " + id);
        }

    }

    @DeleteMapping("/delete/{id}")
    public String deleteMember(@PathVariable long id){
        Optional<Member> member = memberRepository.findById(id);
        if(member.isPresent()) {
            memberRepository.delete(member.get());
            return "Member is deleted with id "+id;
        }else {
            throw new RuntimeException("Member not found for the id "+id);
        }
    }
}
