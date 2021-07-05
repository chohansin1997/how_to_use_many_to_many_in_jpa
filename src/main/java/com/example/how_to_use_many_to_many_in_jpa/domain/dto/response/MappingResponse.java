package com.example.how_to_use_many_to_many_in_jpa.domain.dto.response;

import com.example.how_to_use_many_to_many_in_jpa.domain.dto.request.IdRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MappingResponse {

	private Long sort;

	private NameResponse member;

	private NameResponse product;
}
