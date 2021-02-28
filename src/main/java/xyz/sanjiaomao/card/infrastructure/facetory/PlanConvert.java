package xyz.sanjiaomao.card.infrastructure.facetory;

import org.mapstruct.Mapper;
import xyz.sanjiaomao.card.domain.Plan;
import xyz.sanjiaomao.card.infrastructure.db.PlanDO;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-02-28 03:05
 */
@Mapper(componentModel = "spring")
public interface PlanConvert {

  static PlanDO serialize(Plan plan){
    PlanDO planDO = new PlanDO();
    planDO.setId(plan.getId());
    planDO.setAccountId(plan.getAccountId());
    planDO.setPlanName(plan.getPlanName());
    planDO.setContent(plan.getContent());
    planDO.setStart(plan.getStart());
    planDO.setEnd(plan.getEnd());
    planDO.setFinished(plan.getFinished());
    return planDO;
  }

  static Plan deserialize(PlanDO planDO){
    return Plan.newPlan(planDO.getId(), planDO.getAccountId(), planDO.getPlanName(), planDO.getContent(),
        planDO.getStart(), planDO.getEnd(),planDO.getFinished());
  }
}
