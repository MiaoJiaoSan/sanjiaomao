package xyz.sanjiaomao.card.application.event;

import org.springframework.context.ApplicationEvent;
import xyz.sanjiaomao.card.domain.Card;
import xyz.sanjiaomao.shared.event.Event;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-02-28 02:00
 */
public class CardEvent extends Event<Card> {

  private String cardType;
  /**
   * Create a new {@code ApplicationEvent}.
   *
   * @param source the object on which the event initially occurred or with
   *               which the event is associated (never {@code null})
   */
  public CardEvent(Object source, String cardType) {
    super(source);
    this.cardType = cardType;
  }

  public String getCardType() {
    return cardType;
  }
}
