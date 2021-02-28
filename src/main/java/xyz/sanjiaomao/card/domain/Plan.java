package xyz.sanjiaomao.card.domain;

import lombok.Data;

import java.util.Date;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-02-28 01:03
 */
@Data
public class Plan {

  private Long id;

  private Long accountId;

  private String planName;

  private String content;

  private Date start;

  private Date end;

  private String finished;

  public Plan(Long id){
    this.id = id;
  }

  public static Plan newPlan(Long id, Long accountId, String planName, String content, Date start, Date end, String finished){
    Plan plan = new Plan(id);
    plan.setAccountId(accountId);
    plan.setPlanName(planName);
    plan.setContent(content);
    plan.setStart(start);
    plan.setEnd(end);
    plan.setFinished(finished);
    return plan;
  }


  public Card card(Long id, String remark) {
    return Card.newCard(id, this.id, this.start, new Date(), remark);
  }
}
