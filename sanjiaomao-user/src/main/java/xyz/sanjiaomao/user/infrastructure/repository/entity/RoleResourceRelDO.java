package xyz.sanjiaomao.user.infrastructure.repository.entity;

import lombok.Data;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-01-01 20:39
 */
@Data
public class RoleResourceRelDO {

  private Long id;

  private Long roleId;

  private Long resourceId;

  private Integer privilege;

  private Long version;
}
