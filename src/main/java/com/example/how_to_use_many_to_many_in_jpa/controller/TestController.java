package com.example.how_to_use_many_to_many_in_jpa.controller;

import com.example.how_to_use_many_to_many_in_jpa.domain.dto.request.CreateMemberRequest;
import com.example.how_to_use_many_to_many_in_jpa.domain.dto.request.IdRequest;
import com.example.how_to_use_many_to_many_in_jpa.domain.entity.Mapping;
import com.example.how_to_use_many_to_many_in_jpa.domain.entity.Member;
import com.example.how_to_use_many_to_many_in_jpa.domain.entity.Product;
import com.example.how_to_use_many_to_many_in_jpa.domain.service.MappingService;
import com.example.how_to_use_many_to_many_in_jpa.domain.service.MemberService;
import com.example.how_to_use_many_to_many_in_jpa.domain.service.ProductService;
import com.example.how_to_use_many_to_many_in_jpa.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class TestController {

	private final GroupService service;

	private final MemberService memberService;

	private final ProductService productService;

	private final MappingService mappingService;


	@GetMapping(value = "/")
	public String create() {
		CreateMemberRequest memberDto1 = new CreateMemberRequest();
		memberDto1.setName("한신");

		service.createMember(memberDto1);

		CreateMemberRequest memberDto2 = new CreateMemberRequest();
		memberDto2.setName("한신+상품");

		List<IdRequest> products = new ArrayList<>();
		products.add(IdRequest.builder().id(1l).build());
		products.add(IdRequest.builder().id(2l).build());
		products.add(IdRequest.builder().id(3l).build());

		memberDto2.setProducts(products);

		Long memberId = service.createMember(memberDto2);

		System.out.println(service.getMember(memberId));

		return "test";
	}

	@GetMapping(value = "/get")
	public String getMember() {

		Member memberCheck = memberService.get(1l);
		Product productCheck = productService.get(1l);
		Mapping mappingCheck = mappingService.get(1l);

		service.getMember(1l);
		service.getProduct(1l);

		return "test";
	}

	@GetMapping(value = "/getMember")
	public String getMember(Long id) {

		service.getMember(id);

		return "test";
	}
}
