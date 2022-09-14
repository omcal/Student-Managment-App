package com.example.demo.service.Member;

import com.example.demo.entity.MemberEntity.Member;
import com.example.demo.repository.MemberRepo.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AdminService {
    private final MemberRepository memberRepository;

    public String deactivateStudent(@PathVariable Long id){
        Optional<Member> member = memberRepository.findById(id);
        if (member.isPresent()){
            member.get().setActive(false);
            return  "Deactivated Student";
        }
        return "There is a error";
    }
    public List<Member> getActiveList(){
        List<Member> activeMember=new ArrayList<>();
        for (Member member:memberRepository.findAll()) {
            if (member.isActive()){
                activeMember.add(member);
            }
        }
        return activeMember;
    }

    public List<Member> getActiveStudentList(){
        List<Member> activeStudent=new ArrayList<>();
        for (Member member: getActiveList()){
            if (member.getRole().toString().equals("STUDENT")){
                activeStudent.add(member);
            }
        }
        return activeStudent;
    }

}
