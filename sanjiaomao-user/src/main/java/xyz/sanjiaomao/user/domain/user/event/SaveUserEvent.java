package xyz.sanjiaomao.user.domain.user.event;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2020-12-29 13:26
 */
@Data
public class SaveUserEvent extends ApplicationEvent {
  /**
   * Create a new {@code ApplicationEvent}.
   *
   * @param aggregation the object on which the event initially occurred or with
   * which the event is associated (never {@code null})
   */
  private Long userId;
  private Long actId;

  public SaveUserEvent(Long userId, Long actId) {
    super("SaveUserEvent");
    this.userId = userId;
    this.actId = actId;
  }
}
