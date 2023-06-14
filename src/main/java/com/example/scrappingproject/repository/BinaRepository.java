package com.example.scrappingproject.repository;

import com.example.scrappingproject.entity.BinaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BinaRepository extends JpaRepository<BinaEntity,Long> {

    BinaEntity findByBinaid(String binaid);
}
