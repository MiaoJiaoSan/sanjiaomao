package xyz.sanjiaomao.user.infrastructure.repository.entity;

import lombok.Data;

@Data
public class ActRoleRelDO {

  private Long id;

  private Long actId;

  private Long roleId;

  private Long version;
}
