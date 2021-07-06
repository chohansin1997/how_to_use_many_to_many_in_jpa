package com.example.how_to_use_many_to_many_in_jpa.service;

import com.example.how_to_use_many_to_many_in_jpa.domain.dto.request.CreateMemberRequest;
import com.example.how_to_use_many_to_many_in_jpa.domain.dto.request.CreateProductRequest;
import com.example.how_to_use_many_to_many_in_jpa.domain.dto.request.IdRequest;
import com.example.how_to_use_many_to_many_in_jpa.domain.dto.response.MemberResponse;
import com.example.how_to_use_many_to_many_in_jpa.domain.dto.response.ProductResponse;
import com.example.how_to_use_many_to_many_in_jpa.domain.entity.Mapping;
import com.example.how_to_use_many_to_many_in_jpa.domain.entity.Member;
import com.example.how_to_use_many_to_many_in_jpa.domain.entity.Product;
import com.example.how_to_use_many_to_many_in_jpa.domain.service.MappingService;
import com.example.how_to_use_many_to_many_in_jpa.domain.service.MemberService;
import com.example.how_to_use_many_to_many_in_jpa.domain.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GroupService {

	private final ModelMapper modelMapper;
	private final MemberService memberService;
	private final ProductService productService;
	private final MappingService mappingService;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Long createMember(CreateMemberRequest dto) {

		Member member = Member.createMember(dto.getName());

		memberService.create(member);

		if (dto.getProducts() != null) {
			for (IdRequest id : dto.getProducts()) {
				Product product = productService.get(id.getId());

				mappingService.create(Mapping.createMapping(1l, product, member));
			}
		}
		return member.getId();
	}

	public MemberResponse getMember(Long id) {
		Member member = memberService.get(id);
		MemberResponse memberResponse = modelMapper.map(memberService.get(id), MemberResponse.class);

		return memberResponse;
	}

	@Transactional
	public Long createProduct(CreateProductRequest dto) {

		Product product = Product.createProduct(dto.getName());

		productService.create(product);

		List<Member> Members = new ArrayList<>();
		if (dto.getMembers() != null) {
			for (IdRequest id : dto.getMembers()) {
				Member member = memberService.get(id.getId());

				Members.add(member);
			}
		}

//		product.updateMember(Members);
		return product.getId();
	}

	public Long getProduct(Long id) {
		Product product = productService.get(id);
		ProductResponse memberResponse = modelMapper.map(productService.get(id), ProductResponse.class);

		return null;
	}

}
