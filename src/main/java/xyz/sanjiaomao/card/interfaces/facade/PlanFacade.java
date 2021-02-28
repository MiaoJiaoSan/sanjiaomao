package xyz.sanjiaomao.card.interfaces.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import xyz.sanjiaomao.card.application.CardCmdService;
import xyz.sanjiaomao.card.application.PlanCmdService;
import xyz.sanjiaomao.shared.annotation.Auth;
import xyz.sanjiaomao.shared.cmd.CreatePlanCmd;
import xyz.sanjiaomao.shared.cmd.PlanEventCmd;
import xyz.sanjiaomao.shared.dto.ResultDTO;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-02-28 02:21
 */
@RequestMapping("/plan")
@RestController
public class PlanFacade {

  @Autowired
  private PlanCmdService planCmdService;

  @Autowired
  private CardCmdService cardCmdService;

  @Auth
  @PostMapping
  public ResultDTO createPlan(@Validated @RequestBody CreatePlanCmd cmd){
    planCmdService.createPlan(cmd);
    return new ResultDTO(true);
  }

  @PostMapping("/{planId}/card")
  public ResultDTO card(@PathVariable Long planId, @Validated @RequestBody PlanEventCmd cmd){
    cardCmdService.card(planId, cmd);
    return new ResultDTO(true);
  }

}
