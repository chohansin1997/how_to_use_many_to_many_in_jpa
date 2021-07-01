package com.example.how_to_use_many_to_many_in_jpa.controller;

import com.example.how_to_use_many_to_many_in_jpa.domain.dto.request.CreateMemberRequest;
import com.example.how_to_use_many_to_many_in_jpa.domain.dto.request.CreateProductRequest;
import com.example.how_to_use_many_to_many_in_jpa.domain.dto.request.IdRequest;
import com.example.how_to_use_many_to_many_in_jpa.domain.entity.Member;
import com.example.how_to_use_many_to_many_in_jpa.domain.entity.Product;
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

	@GetMapping(value = "/")
	public String create(CreateMemberRequest dto) {

		service.createMember(dto);

		return null;
	}

	@GetMapping(value = "/dataRunner")
	@Transactional
	public String createData() {

		Member member = Member.createMember("한신");
		memberService.create(member);

		Product product1 = Product.createProduct("치킨");
		productService.create(product1);
		Product product2 = Product.createProduct("양념 치킨");
		productService.create(product2);
		Product product3 = Product.createProduct("간장 치킨");
		productService.create(product3);
		Product product4 = Product.createProduct("후추 치킨");
		productService.create(product4);

		List<Product> products = new ArrayList<>();

		products.add(product1);
		products.add(product2);
		products.add(product3);
		products.add(product4);

		member.updateProducts(products);

		return "test";
	}

	@GetMapping(value = "/get")
	public String getMember() {
		service.getMember(1l);
		service.getProduct(1l);

		return "test";
	}
}
