package xyz.sanjiaomao.card.application;

import cn.hutool.core.date.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.sanjiaomao.card.application.event.CardEvent;
import xyz.sanjiaomao.card.domain.Card;
import xyz.sanjiaomao.card.domain.Plan;
import xyz.sanjiaomao.card.domain.repository.PlanRepository;
import xyz.sanjiaomao.card.domain.service.PlanDomainService;
import xyz.sanjiaomao.shared.cmd.CreatePlanCmd;
import xyz.sanjiaomao.shared.constant.PlanConstant;
import xyz.sanjiaomao.shared.snowflake.SnowflakeUtil;

import java.util.Date;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-02-28 01:39
 */
@Service
public class PlanCmdService {

  @Autowired
  private PlanDomainService planDomainService;
  @Autowired
  private PlanRepository planRepository;
  @Autowired
  private ApplicationEventPublisher applicationEventPublisher;

  @Transactional(rollbackFor = Exception.class)
  public void createPlan(CreatePlanCmd cmd){
    Plan plan = planRepository.findByAccountIdAndFinished(cmd.getAccountId(), PlanConstant.PENDING);
    planDomainService.isCreate(plan);
    plan = Plan.newPlan(SnowflakeUtil.PLAN.nextId(), cmd.getAccountId(),
        cmd.getPlanName(), cmd.getContent(), DateUtil.beginOfDay(new Date()), cmd.getEnd(), PlanConstant.PENDING);

    Card card = plan.card(SnowflakeUtil.CARD.nextId(), cmd.getRemark());
    planRepository.save(plan);
    //发布计划创建事件
    applicationEventPublisher.publishEvent(new CardEvent(card, PlanConstant.START));
  }

}
