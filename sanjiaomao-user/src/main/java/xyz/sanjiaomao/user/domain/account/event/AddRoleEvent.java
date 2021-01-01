package xyz.sanjiaomao.user.domain.account.event;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

@Data
public class AddRoleEvent extends ApplicationEvent {
  /**
   * Create a new {@code ApplicationEvent}.
   *
   * @param source the object on which the event initially occurred or with
   * which the event is associated (never {@code null})
   */
  private Long actId;
  private Long roleId;

  public AddRoleEvent(Long actId, Long roleId) {
    super("AddRoleEvent");
    this.actId = actId;
    this.roleId = roleId;
  }
}
