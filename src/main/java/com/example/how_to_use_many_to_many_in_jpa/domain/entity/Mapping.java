package com.example.how_to_use_many_to_many_in_jpa.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name = "TB_MAPPING")
@Getter
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor(access = PROTECTED)
public class Mapping {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;

	private Long sort;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "memberId")
	private Member member;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "productId")
	private Product product;

	private Mapping(Long sort) {
		this.sort = sort;
	}

	public Mapping(Long sort, Product product, Member member) {
		this.sort = sort;
		this.product = product;
		this.member = member;
	}

	public static Mapping createMapping(Long sort) {
		return new Mapping(sort);
	}

	public static Mapping createMapping(Long sort, Product product, Member member) {
		return new Mapping(sort, product, member);
	}

	public void updateMember(Member member) {
		this.member = member;
	}

	public void updateProduct(Product product) {
		this.product = product;
	}

	public void updateProductAndMember(Product product, Member member) {
		this.product = product;
		this.member = member;
	}
}
