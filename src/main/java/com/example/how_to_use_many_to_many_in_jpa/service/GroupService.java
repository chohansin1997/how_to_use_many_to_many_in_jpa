package com.example.how_to_use_many_to_many_in_jpa.service;

import com.example.how_to_use_many_to_many_in_jpa.domain.dto.request.CreateMemberRequest;
import com.example.how_to_use_many_to_many_in_jpa.domain.dto.request.CreateProductRequest;
import com.example.how_to_use_many_to_many_in_jpa.domain.dto.request.IdRequest;
import com.example.how_to_use_many_to_many_in_jpa.domain.dto.response.MemberResponse;
import com.example.how_to_use_many_to_many_in_jpa.domain.dto.response.ProductResponse;
import com.example.how_to_use_many_to_many_in_jpa.domain.entity.Member;
import com.example.how_to_use_many_to_many_in_jpa.domain.entity.Product;
import com.example.how_to_use_many_to_many_in_jpa.domain.service.MemberService;
import com.example.how_to_use_many_to_many_in_jpa.domain.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.util.Members;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupService {

	private final ModelMapper modelMapper;

	private final MemberService memberService;

	private final ProductService productService;

	public Long createMember(CreateMemberRequest dto) {

		Member member = Member.createMember(dto.getName());

		memberService.create(member);
		List<Product> products = new ArrayList<>();

//		for (IdRequest id : dto.getProducts()) {
//			Product product = productService.get(id.getId());
//			products.add(product);
//		}
		member.updateProducts(products);

		return member.getId();
	}

	public Long getMember(Long id) {
		MemberResponse memberResponse = modelMapper.map(memberService.get(id), MemberResponse.class);

		return null;
	}

	public Long createProduct(CreateProductRequest dto) {

		Product product = Product.createProduct(dto.getName());

		productService.create(product);
		List<Member> Members = new ArrayList<>();

//		for (IdRequest id : dto.getMembers()) {
//			Member member = memberService.get(id.getId());
//			Members.add(member);
//		}

		product.updateMember(Members);
		return product.getId();
	}

	public Long getProduct(Long id) {
		Product product = productService.get(id);
		ProductResponse memberResponse = modelMapper.map(productService.get(id), ProductResponse.class);

		return null;
	}

}
