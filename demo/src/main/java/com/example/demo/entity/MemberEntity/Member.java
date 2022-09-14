package com.example.demo.entity.MemberEntity;

import com.example.demo.entity.Enums.Role;
import com.example.demo.entity.HWEntity.HWs;
import com.example.demo.entity.LectureEntity.Lecture;
import com.sun.istack.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "members_table")
public class Member implements UserDetails {

    @Id
    @SequenceGenerator(name="Member_sequence",sequenceName = "Member_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="Member_sequence" )
    @Column(name = "member_id")
    private Long id;
    @NotNull
    private String name;

    @NotNull
    private String surname;


    @NotNull
    private String email;

    @NotNull
    private String password;

    private  boolean isActive;

    private int student_id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Role role;


    @OneToMany(mappedBy = "member",fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    private List<HWs> hwsList=new ArrayList<>();

    @OneToMany(mappedBy = "member",fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    private List<Lecture> lectureList =new ArrayList<>();

    private boolean locked=false;
    private boolean enabled=false;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority=new SimpleGrantedAuthority(getRole().name());

        return Collections.singletonList(authority);
    }

    public Member(String name, String surname, String email, String password, Role role) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.role = role;

        this.isActive=true;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return  getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
