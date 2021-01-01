package xyz.sanjiaomao.user.domain.account.event;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-01-01 18:58
 */
@Data
public class RemoveRoleEvent extends ApplicationEvent {

  private Long actId;
  private Long roleId;

  public RemoveRoleEvent(Long actId, Long roleId) {
    super("RemoveRoleEvent");
    this.actId = actId;
    this.roleId = roleId;
  }
}
