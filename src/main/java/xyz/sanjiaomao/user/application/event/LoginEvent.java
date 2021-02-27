package xyz.sanjiaomao.user.application.event;

import org.springframework.context.ApplicationEvent;

public class LoginEvent<T> extends ApplicationEvent {

  private final String password;

  /**
   * Create a new {@code ApplicationEvent}.
   *
   * @param source the object on which the event initially occurred or with
   *               which the event is associated (never {@code null})
   */
  public LoginEvent(Object source, String password) {
    super(source);
    this.password = password;
  }

  @Override
  public T getSource() {
    return (T) super.getSource();
  }

  public String getPassword() {
    return password;
  }
}
