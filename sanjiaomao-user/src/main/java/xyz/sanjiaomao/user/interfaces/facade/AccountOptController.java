package xyz.sanjiaomao.user.interfaces.facade;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.sanjiaomao.user.application.cmd.opt.SaveActCmd;
import xyz.sanjiaomao.user.application.service.AccountOptService;
import xyz.sanjiaomao.user.domain.user.entity.Account;
import xyz.sanjiaomao.user.interfaces.assembler.AccountAssembler;
import xyz.sanjiaomao.user.interfaces.dto.AccountDTO;

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
  public Boolean save(@RequestBody @Validated AccountDTO dto) {
    SaveActCmd cmd = accountAssembler.convert(dto);
    return accountOptService.save(cmd);
  }
}
