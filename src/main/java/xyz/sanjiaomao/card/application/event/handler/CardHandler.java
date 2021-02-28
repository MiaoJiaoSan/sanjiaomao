package xyz.sanjiaomao.card.application.event.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import xyz.sanjiaomao.card.application.event.CardEvent;
import xyz.sanjiaomao.card.domain.Card;
import xyz.sanjiaomao.card.domain.Plan;
import xyz.sanjiaomao.card.domain.repository.CardRepository;
import xyz.sanjiaomao.card.domain.repository.PlanRepository;
import xyz.sanjiaomao.shared.constant.PlanConstant;

import java.util.Date;
import java.util.Objects;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-02-28 02:05
 */
@Component
public class CardHandler {

  @Autowired
  private CardRepository cardRepository;

  @Autowired
  private PlanRepository planRepository;

  @EventListener
  public void card(CardEvent event){
    Card card = event.getSource();
    if(Objects.equals(event.getCardType(), PlanConstant.END)){
      card.setEnd(new Date());
    }
    cardRepository.save(card);
  }


  @EventListener(condition = "event.getSource().getEnd() != null")
  public void plan(CardEvent event){
    Card card = event.getSource();
    Plan plan = planRepository.findById(card.getPlanId());
    if(Objects.equals(plan.getEnd(), card.getEnd())){
      plan.setFinished(PlanConstant.COMPLETE);
      planRepository.save(plan);
    }
  }
}
