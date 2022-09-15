package com.example.demo.service.Member;

import com.example.demo.entity.MemberEntity.Member;
import com.example.demo.repository.MemberRepo.MemberRepository;
import lombok.AllArgsConstructor;
import net.bytebuddy.implementation.bytecode.Throw;
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
        try {
            if (member.isPresent()){
                if (member.get().getRole().toString().equals("STUDENT")){
                    member.get().setActive(false);
                    memberRepository.save(member.get());
                    return  "Deactivated Student";
                }
                return "User is not a student";

            }
            else{
                throw new RuntimeException("User not found");
            }
        }catch (Exception e){
            return e.getMessage();
        }
    }
    public String updateUser(Member member){
        try{
            if (memberRepository.findByEmail(member.getEmail()).isPresent()){
                Member temp=memberRepository.findByEmail(member.getEmail()).get();
                member.setId(temp.getId());
                memberRepository.save(member);
                return "The user updated";
            }
            else throw new IllegalArgumentException("There is a mistake or try to add user");
        }catch (Exception e){
            return e.getMessage();
        }
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
