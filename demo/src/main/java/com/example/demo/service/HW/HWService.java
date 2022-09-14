package com.example.demo.service.HW;

import com.example.demo.repository.HWRepo.HWRepository;
import com.example.demo.entity.HWEntity.HWs;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class HWService {


    private final HWRepository hwRepository;



    public String addHW(HWs HWs) {

        try{
            hwRepository.save(HWs);
        }catch (Exception e){
            return e.getMessage()+"\n Please check your inputs \n";

        }
        return "The HW Posted";
    }
    public List<HWs> hWsList(){
        return hwRepository.findAll();
    }
    public  HWs getOneHW(long id){
        if (hwRepository.findById(id).isEmpty()){
            throw new RuntimeException("hope");
        }
        return hwRepository.findById(id).get();
    }
    public boolean addGrade(int studentId,int grade,long hw_id){

        if (!hwRepository.existsById(hw_id)){
            return false;
        } else if (grade<0 || grade>100) {
            return false;
        }
        HWs hWs=hwRepository.getById(hw_id);
        hWs.getGrade().put(studentId,grade);
        hwRepository.save(hWs);
        return true;
    }

}
