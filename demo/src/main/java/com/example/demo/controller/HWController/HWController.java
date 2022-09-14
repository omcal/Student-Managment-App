package com.example.demo.controller.HWController;

import com.example.demo.dto.GradePostingRequest;
import com.example.demo.dto.HWPostingRequest;
import com.example.demo.entity.HWEntity.HWs;
import com.example.demo.service.HW.HWAddService;
import com.example.demo.service.HW.HWService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor

public class HWController {
    private final HWAddService HWAddService;
    private final HWService hwService;


    @PostMapping(path = "/hw/add",consumes = "application/json")
    public String register(@RequestBody HWPostingRequest request ){
        return HWAddService.registerHW(request);
    }
    @GetMapping("/hw/all")
    public List<HWs> allHws(){
        return hwService.hWsList();
    }


}
