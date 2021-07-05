package com.example.how_to_use_many_to_many_in_jpa.domain.repository;

import com.example.how_to_use_many_to_many_in_jpa.domain.entity.Mapping;
import com.example.how_to_use_many_to_many_in_jpa.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MappingRepository extends JpaRepository<Mapping, Long> {
}
