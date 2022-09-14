package com.example.demo.service.HW;


import com.example.demo.dto.HWPostingRequest;
import com.example.demo.entity.HWEntity.HWs;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

// a service to add Jobs
@Service
@AllArgsConstructor
public class HWAddService {
    private final com.example.demo.service.HW.HWService HWService;
    public  String registerHW(HWPostingRequest request){
        return HWService.addHW(new HWs(request.getTitle(),request.getContent(),request.getFinal_date(),request.getLink(),request.getPoster_id()));
    }

}
