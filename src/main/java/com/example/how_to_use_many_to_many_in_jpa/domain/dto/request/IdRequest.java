package com.example.how_to_use_many_to_many_in_jpa.domain.dto.request;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IdRequest {

  /**
   * 일련 번호
   */
  @NotNull
  private Long id;

}
