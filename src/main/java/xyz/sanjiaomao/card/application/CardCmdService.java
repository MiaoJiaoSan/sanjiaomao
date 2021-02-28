package xyz.sanjiaomao.card.application;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import xyz.sanjiaomao.card.application.event.CardEvent;
import xyz.sanjiaomao.card.domain.Card;
import xyz.sanjiaomao.card.domain.repository.CardRepository;
import xyz.sanjiaomao.card.domain.service.PlanDomainService;
import xyz.sanjiaomao.shared.cmd.PlanEventCmd;
import xyz.sanjiaomao.shared.cmd.ModifyCardCmd;
import xyz.sanjiaomao.shared.constant.PlanConstant;
import xyz.sanjiaomao.shared.snowflake.SnowflakeUtil;

import java.util.Date;
import java.util.Objects;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-02-28 01:55
 */
@Service
public class CardCmdService {

  @Autowired
  private PlanDomainService planDomainService;

  @Autowired
  private CardRepository cardRepository;
  @Autowired
  private ApplicationEventPublisher applicationEventPublisher;

  public void card(Long planId, PlanEventCmd cmd){
    Date date = new Date();
    DateTime beginOfDay = DateUtil.beginOfDay(date);
    Card card = cardRepository.findByPlanIdAndCardDate(planId, beginOfDay);
    if(Objects.isNull(card)){
      card = Card.newCard(SnowflakeUtil.CARD.nextId(),planId, beginOfDay, date, cmd.getRemark());
      applicationEventPublisher.publishEvent(new CardEvent(card, PlanConstant.START));
      return;
    }
    applicationEventPublisher.publishEvent(new CardEvent(card, PlanConstant.END));
  }


  public void modifyCardRemark(Long id, ModifyCardCmd cmd){
    Card card = cardRepository.findById(id);
    planDomainService.isModifyRemark(card);
    planDomainService.modifyCardRemark(card, cmd.getRemark());
    cardRepository.save(card);
  }
}
