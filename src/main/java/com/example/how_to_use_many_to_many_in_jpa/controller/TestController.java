package com.example.how_to_use_many_to_many_in_jpa.controller;

import com.example.how_to_use_many_to_many_in_jpa.domain.dto.request.CreateMemberRequest;
import com.example.how_to_use_many_to_many_in_jpa.domain.dto.request.CreateProductRequest;
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
import org.springframework.transaction.annotation.Transactional;
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
	public String create(CreateMemberRequest dto) {

		dto.setName("한신");
//		List<IdRequest> idRequests = new ArrayList<>();
//		IdRequest idRequest1 = new IdRequest(1l);
//		idRequests.add(idRequest1);
//		IdRequest idRequest2 = new IdRequest(2l);
//		idRequests.add(idRequest2);
//		IdRequest idRequest3 = new IdRequest(3l);
//		idRequests.add(idRequest3);
//
//		dto.setProducts(idRequests);

		service.createMember(dto);

		return "test";
	}
	@GetMapping(value = "/get")
	public String getMember() {

		Member memberCheck = memberService.get(1l);
		Product productCheck = productService.get(1l);
		Mapping mappingCheck = mappingService.get(1l);

		return "test";
	}
}
