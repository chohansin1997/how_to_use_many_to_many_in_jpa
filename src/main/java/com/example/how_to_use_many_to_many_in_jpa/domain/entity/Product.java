package com.example.how_to_use_many_to_many_in_jpa.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name = "TB_PRODUCT")
@Getter
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor(access = PROTECTED)
public class Product {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;

	private String name;

	@JoinColumn(name = "membersId")
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Member> members;

	private Product(String name) {
		this.name = name;
	}

	public static Product createProduct(String name) {
		return new Product(name);
	}

	public void updateMember(List<Member> members) {
		this.members = members;
	}
}
