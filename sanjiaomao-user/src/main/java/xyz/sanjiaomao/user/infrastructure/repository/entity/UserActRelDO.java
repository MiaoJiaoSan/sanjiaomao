package xyz.sanjiaomao.user.infrastructure.repository.entity;

import lombok.Data;

@Data
public class UserActRelDO {

  private Long id;

  private Long userId;

  private Long actId;

  private Long version;
}
