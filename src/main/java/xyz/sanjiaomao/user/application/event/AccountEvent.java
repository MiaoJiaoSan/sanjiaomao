package xyz.sanjiaomao.user.application.event;

import xyz.sanjiaomao.shared.event.Event;
import xyz.sanjiaomao.user.domain.Account;

public class AccountEvent extends Event<Account> {

  private final String password;

  /**
   * Create a new {@code ApplicationEvent}.
   *
   * @param source the object on which the event initially occurred or with
   *               which the event is associated (never {@code null})
   */
  public AccountEvent(Object source, String password) {
    super(source);
    this.password = password;
  }

  public String getPassword() {
    return password;
  }
}
