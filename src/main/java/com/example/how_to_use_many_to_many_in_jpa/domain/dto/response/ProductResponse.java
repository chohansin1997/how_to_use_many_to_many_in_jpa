package com.example.how_to_use_many_to_many_in_jpa.domain.dto.response;

import com.example.how_to_use_many_to_many_in_jpa.domain.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {

	private Long id;

	private String name;

	private List<MappingResponse> mapping;
}
