package xyz.sanjiaomao.card.interfaces.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import xyz.sanjiaomao.card.application.CardCmdService;
import xyz.sanjiaomao.shared.cmd.ModifyCardCmd;
import xyz.sanjiaomao.shared.dto.ResultDTO;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-02-28 02:36
 */
@RequestMapping("/card")
@RestController
public class CardFacade {

  @Autowired
  private CardCmdService cardCmdService;

  @PutMapping("/{id}")
  public ResultDTO modifyRemark(@PathVariable Long id, @Validated @RequestBody ModifyCardCmd cmd){
    cardCmdService.modifyCardRemark(id, cmd);
    return new ResultDTO(true);
  }
}
