package com.example.how_to_use_many_to_many_in_jpa.domain.dto.request;

import com.example.how_to_use_many_to_many_in_jpa.domain.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateMemberRequest {

	String name;

	List<IdRequest> products;

}
