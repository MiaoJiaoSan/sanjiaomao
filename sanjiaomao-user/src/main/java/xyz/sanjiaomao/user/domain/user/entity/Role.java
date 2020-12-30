package xyz.sanjiaomao.user.domain.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {

  private Long id;

  private String name;

  private Long version;
}
