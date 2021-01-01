package xyz.sanjiaomao.user.domain.role.event;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-01-01 20:10
 */
@Data
public class AddResourceEvent extends ApplicationEvent {

  private Long roleId;

  private Long resourceId;

  private Integer privilege;

  public AddResourceEvent(Long roleId, Long resourceId, Integer privilege) {
    super("AddResourceEvent");
    this.roleId = roleId;
    this.resourceId = resourceId;
    this.privilege = privilege;
  }
}
