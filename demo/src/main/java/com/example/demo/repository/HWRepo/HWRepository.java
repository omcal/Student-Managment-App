package com.example.demo.repository.HWRepo;

import com.example.demo.entity.HWEntity.HWs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface HWRepository extends JpaRepository<HWs,Long> {
    @Override
    Optional<HWs> findById(Long aLong);
    List<HWs> findAll();

}
