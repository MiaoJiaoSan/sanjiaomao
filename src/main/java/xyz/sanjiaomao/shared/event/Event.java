package xyz.sanjiaomao.shared.event;

import org.springframework.context.ApplicationEvent;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-02-28 02:01
 */
public abstract class Event<T> extends ApplicationEvent {

  /**
   * Create a new {@code ApplicationEvent}.
   *
   * @param source the object on which the event initially occurred or with
   *               which the event is associated (never {@code null})
   */
  public Event(Object source) {
    super(source);
  }

  @Override
  public T getSource() {
    return (T) super.getSource();
  }
}
