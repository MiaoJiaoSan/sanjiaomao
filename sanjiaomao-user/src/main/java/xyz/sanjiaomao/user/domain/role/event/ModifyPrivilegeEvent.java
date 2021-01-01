package xyz.sanjiaomao.user.domain.role.event;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-01-01 21:00
 */
@Data
public class ModifyPrivilegeEvent extends ApplicationEvent {

  private Long roleId;

  private Long resourceId;

  private Integer privilege;

  /**
   * Create a new {@code ApplicationEvent}.
   *
   * @param source the object on which the event initially occurred or with
   *               which the event is associated (never {@code null})
   */
  public ModifyPrivilegeEvent(Long roleId, Long resourceId, Integer privilege) {
    super("ModifyPrivilegeEvent");
    this.roleId = roleId;
    this.resourceId = resourceId;
    this.privilege = privilege;
  }
}
