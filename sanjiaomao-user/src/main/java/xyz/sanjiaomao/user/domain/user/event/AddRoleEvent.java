package xyz.sanjiaomao.user.domain.user.event;

import lombok.Data;
import org.springframework.context.ApplicationEvent;
import xyz.sanjiaomao.user.domain.user.entity.UserAggregation;

@Data
public class AddRoleEvent extends ApplicationEvent {
  /**
   * Create a new {@code ApplicationEvent}.
   *
   * @param source the object on which the event initially occurred or with
   *               which the event is associated (never {@code null})
   */
  private UserAggregation aggregation;
  public AddRoleEvent(UserAggregation aggregation) {
    super(aggregation);
    this.aggregation = aggregation;
  }
}
