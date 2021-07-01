package com.example.how_to_use_many_to_many_in_jpa.domain.service;

import com.example.how_to_use_many_to_many_in_jpa.domain.dto.request.CreateMemberRequest;
import com.example.how_to_use_many_to_many_in_jpa.domain.entity.Member;
import com.example.how_to_use_many_to_many_in_jpa.domain.repository.MemberRepository;
import com.example.how_to_use_many_to_many_in_jpa.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

	private final MemberRepository memberRepository;

	@Transactional
	public Long create(Member entity) {

		return memberRepository.save(entity).getId();
	}

	public Member get(Long id) {

		return memberRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}
}