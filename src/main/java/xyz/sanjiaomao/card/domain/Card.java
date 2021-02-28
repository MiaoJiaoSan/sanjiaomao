package xyz.sanjiaomao.card.domain;

import lombok.Data;

import java.util.Calendar;
import java.util.Date;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-02-28 00:39
 */
@Data
public class Card {

  private Long id;

  private Long planId;

  private Date cardDate;

  private Date start;

  private Date end;

  private String remark;

  public Card(Long id){
    this.id = id;
  }

  public static Card newCard(Long id, Long planId, Date cardDate, Date start, String remark){
    Card card = new Card(id);
    card.setPlanId(planId);
    card.setCardDate(cardDate);
    card.setStart(start);
    card.setRemark(remark);
    return card;
  }

  public void modify(String remark){
    this.remark = remark;
  }
}
