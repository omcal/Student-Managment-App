package com.example.demo.service.Member;

import com.example.demo.entity.MemberEntity.Member;
import com.example.demo.repository.MemberRepo.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class MemberService implements UserDetailsService {

    private final static String email_not_found="We didn't find such a %s  email ";
    @Autowired
    private final MemberRepository memberRepository;
    @Autowired
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Member> member= Optional.ofNullable(memberRepository.findMemberByEmail(email));

        if(member.isPresent()){
            member.get();
        }
        return member.get();
    }
    public String signUp(Member member) {
        boolean isUserExist=memberRepository.existsByEmail(member.getEmail());
        if(isUserExist){
            throw new IllegalStateException("User already exists");
        }
        String hashedPassword=bCryptPasswordEncoder.encode(member.getPassword());

        member.setPassword(hashedPassword);
        if (member.getRole().toString().equals("STUDENT")){
            int randomId=randomGen();
            int counter=0;
            while (memberRepository.existsMemberByStudent_id(randomId)){
                 randomId=randomGen();
                 counter++;
                 if (counter==10){
                     return "The Database is Full";
                 }
            }
            member.setStudent_id(randomId);
        }

        memberRepository.save(member);
        //member.setPassword(hashedPassword);


        return "A new user has been created";


    }
    public int randomGen() {
        Random r = new Random( System.currentTimeMillis() );
        return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
    }


}
