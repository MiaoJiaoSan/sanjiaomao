package xyz.sanjiaomao.user.interfaces.facade;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.sanjiaomao.user.application.cmd.opt.AddRoleCmd;
import xyz.sanjiaomao.user.application.cmd.opt.SaveActCmd;
import xyz.sanjiaomao.user.application.service.AccountOptService;
import xyz.sanjiaomao.user.interfaces.assembler.AccountAssembler;
import xyz.sanjiaomao.user.interfaces.dto.AddRoleDTO;
import xyz.sanjiaomao.user.interfaces.dto.SaveAccountDTO;

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
  @Autowired
  private AccountAssembler accountAssembler;

  @PostMapping("/save")
  public Boolean save(@RequestBody @Validated SaveAccountDTO dto) {
    SaveActCmd cmd = accountAssembler.convert(dto);
    return accountOptService.save(cmd);
  }

  @PostMapping("/addRole")
  public Boolean addRole(@RequestBody @Validated AddRoleDTO dto) {
    AddRoleCmd cmd = accountAssembler.convert(dto);
    return accountOptService.addRole(cmd);
  }
}
