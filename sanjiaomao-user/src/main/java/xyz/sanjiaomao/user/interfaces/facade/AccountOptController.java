package xyz.sanjiaomao.user.interfaces.facade;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.sanjiaomao.shared.dto.ResultDTO;
import xyz.sanjiaomao.user.application.cmd.opt.AddRoleCmd;
import xyz.sanjiaomao.user.application.cmd.opt.ModifyActCmd;
import xyz.sanjiaomao.user.application.cmd.opt.SaveActCmd;
import xyz.sanjiaomao.user.application.service.AccountOptService;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2020-12-27 23:44
 */
@RequestMapping("/account")
@RestController
@Slf4j
public class AccountOptController {


  @Autowired
  private AccountOptService accountOptService;

  @PostMapping
  public ResultDTO<Boolean> save(@RequestBody @Validated SaveActCmd cmd) {
    return new ResultDTO<>(accountOptService.save(cmd));
  }

  public ResultDTO<Boolean> modify(@RequestBody @Validated ModifyActCmd cmd) {
    return new ResultDTO<>(accountOptService.modify(cmd));
  }

  @PostMapping("/addRole")
  public ResultDTO<Boolean> addRole(@RequestBody @Validated AddRoleCmd cmd) {
    return new ResultDTO<>(accountOptService.addRole(cmd));
  }
}
