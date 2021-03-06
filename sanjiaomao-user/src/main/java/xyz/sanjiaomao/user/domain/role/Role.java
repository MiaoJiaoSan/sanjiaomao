package xyz.sanjiaomao.user.domain.role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {

  private Long id;

  private String name;

  public Role(Long id) {
    this.id = id;
  }
}
