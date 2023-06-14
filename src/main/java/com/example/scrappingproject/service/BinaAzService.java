package com.example.scrappingproject.service;

import com.example.scrappingproject.dto.BinaDTO;
import com.example.scrappingproject.entity.BinaEntity;
import com.example.scrappingproject.repository.BinaRepository;
import com.example.scrappingproject.util.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BinaAzService {
    private final BinaRepository repository;
    private final Mapper mapper;

    public List<BinaDTO> getall(){
        return repository.findAll().stream().map(n->mapper.entityToDto(n)).collect(Collectors.toList());
    }
}
