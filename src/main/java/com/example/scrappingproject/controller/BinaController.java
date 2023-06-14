package com.example.scrappingproject.controller;

import com.example.scrappingproject.dto.BinaDTO;
import com.example.scrappingproject.service.BinaAzService;
import com.example.scrappingproject.service.ScrapingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/binaaz")
public class BinaController {
    private final BinaAzService service;


    @GetMapping("/all")
    public List<BinaDTO> getalldata()  {
       return service.getall();

    }
}
