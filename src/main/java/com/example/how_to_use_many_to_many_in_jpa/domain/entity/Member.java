package com.example.how_to_use_many_to_many_in_jpa.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.annotation.processing.Generated;
import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name = "TB_MEMBER")
@Getter
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor(access = PROTECTED)
public class Member {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;

	private String name;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
	private List<Mapping> mapping;


	private Member(String name) {
		this.name = name;
	}

	public static Member createMember(String name) {
		return new Member(name);
	}

	public void updateMapping(List<Mapping> mapping) {
		this.mapping = mapping;
	}
}
