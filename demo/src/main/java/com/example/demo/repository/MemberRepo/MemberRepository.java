package com.example.demo.repository.MemberRepo;


import com.example.demo.entity.MemberEntity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
@EnableJpaRepositories
public interface MemberRepository extends JpaRepository<Member,Long> {
    Optional<Member> findByEmail(String email);
    Member findMemberByEmail(String email);
    boolean existsByEmail(String email);
    Optional<Member> findById(Long id);
    @Query("select (count(m) > 0) from Member m where m.student_id = :id")
    boolean existsMemberByStudent_id(@Param("id") int id);


}
