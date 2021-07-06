package com.example.how_to_use_many_to_many_in_jpa.domain.service;

import com.example.how_to_use_many_to_many_in_jpa.domain.entity.Mapping;
import com.example.how_to_use_many_to_many_in_jpa.domain.repository.MappingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MappingService {

	private final MappingRepository mappingRepository;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Long create(Mapping entity) {

		return mappingRepository.save(entity).getId();
	}

	public Mapping get(Long id) {

		return mappingRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}
}

