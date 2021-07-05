package com.example.how_to_use_many_to_many_in_jpa;

import com.example.how_to_use_many_to_many_in_jpa.domain.entity.Mapping;
import com.example.how_to_use_many_to_many_in_jpa.domain.entity.Member;
import com.example.how_to_use_many_to_many_in_jpa.domain.entity.Product;
import com.example.how_to_use_many_to_many_in_jpa.domain.service.MappingService;
import com.example.how_to_use_many_to_many_in_jpa.domain.service.MemberService;
import com.example.how_to_use_many_to_many_in_jpa.domain.service.ProductService;
import com.example.how_to_use_many_to_many_in_jpa.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataRunner implements ApplicationRunner  {

	private final GroupService service;

	private final MemberService memberService;

	private final ProductService productService;

	private final MappingService mappingService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		//멤버 엔티티 추가
		Member member = Member.createMember("한신");
		memberService.create(member);

		//상품 엔티티 추가
		Product product1 = Product.createProduct("치킨");
		productService.create(product1);
		Product product2 = Product.createProduct("양념 치킨");
		productService.create(product2);
		Product product3 = Product.createProduct("간장 치킨");
		productService.create(product3);
		Product product4 = Product.createProduct("후추 치킨");
		productService.create(product4);

		//맵핑 엔티티 로 2개 연결
		Mapping mapping1 = Mapping.createMapping(1l);
		mapping1.updateProductAndMember(product1, member);
		mappingService.create(mapping1);

		Mapping mapping2 = Mapping.createMapping(2l);
		mapping2.updateProductAndMember(product2, member);
		mappingService.create(mapping2);

		Mapping mapping3 = Mapping.createMapping(3l);
		mapping3.updateProductAndMember(product3, member);
		mappingService.create(mapping3);

		Mapping mapping4 = Mapping.createMapping(4l);
		mapping4.updateProductAndMember(product4, member);
		mappingService.create(mapping4);
	}
}
