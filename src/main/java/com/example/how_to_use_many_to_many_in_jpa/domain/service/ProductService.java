package com.example.how_to_use_many_to_many_in_jpa.domain.service;

import com.example.how_to_use_many_to_many_in_jpa.domain.dto.request.CreateMemberRequest;
import com.example.how_to_use_many_to_many_in_jpa.domain.dto.request.CreateProductRequest;
import com.example.how_to_use_many_to_many_in_jpa.domain.entity.Member;
import com.example.how_to_use_many_to_many_in_jpa.domain.entity.Product;
import com.example.how_to_use_many_to_many_in_jpa.domain.repository.MemberRepository;
import com.example.how_to_use_many_to_many_in_jpa.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {

	private final ProductRepository productRepository;

	@Transactional
	public Long create(Product product) {

		return productRepository.save(product).getId();
	}

	public Product get(Long id) {

		return productRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}
}