package com.example.scrappingproject.util;

import com.example.scrappingproject.dto.BinaDTO;
import com.example.scrappingproject.entity.BinaEntity;
import org.springframework.stereotype.Component;

@org.mapstruct.Mapper
@Component
public class Mapper {

public BinaEntity dtoToEntity(BinaDTO dto){
    BinaEntity entity = new BinaEntity();
    entity.setLocation(dto.getLocation());
    entity.setInfo(dto.getInfo());
    entity.setTarix(dto.getTarix());
    entity.setQiymet(dto.getQiymet());
    return entity;
}

    public BinaDTO entityToDto(BinaEntity entity){
        BinaDTO dto = new BinaDTO();
        dto.setLocation(entity.getLocation());
        dto.setInfo(entity.getInfo());
        dto.setTarix(entity.getTarix());
        dto.setQiymet(entity.getQiymet());
        return dto;
    }

}
