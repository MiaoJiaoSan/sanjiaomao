package xyz.sanjiaomao.user.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.sanjiaomao.shared.snowflake.SnowflakeUtil;
import xyz.sanjiaomao.user.application.cmd.opt.AddRoleCmd;
import xyz.sanjiaomao.user.application.cmd.opt.ModifyActCmd;
import xyz.sanjiaomao.user.application.cmd.opt.RemoveRoleCmd;
import xyz.sanjiaomao.user.application.cmd.opt.SaveActCmd;
import xyz.sanjiaomao.user.domain.account.Account;
import xyz.sanjiaomao.user.domain.account.service.AccountDomainService;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2020-12-27 23:43
 */
@Service
public class AccountOptService {


  @Autowired
  private AccountDomainService accountDomainService;

  @Transactional(rollbackFor = Exception.class)
  public Boolean save(SaveActCmd cmd) {
    Account account = new Account(SnowflakeUtil.ACCOUNT.nextId(),
        cmd.getUsername(), cmd.getPassword(), cmd.getNickname(), cmd.getEmail(), cmd.getPhone());
    return accountDomainService.save(account);
  }

  @Transactional(rollbackFor = Exception.class)
  public Boolean modify(ModifyActCmd cmd) {
    Account account = new Account(cmd.getId(),
        cmd.getUsername(), cmd.getPassword(), cmd.getNickname(), cmd.getEmail(), cmd.getPhone());
    return accountDomainService.modify(account);
  }

  @Transactional(rollbackFor = Exception.class)
  public Boolean addRole(AddRoleCmd cmd) {
    return accountDomainService.addRole(cmd.getActId(), cmd.getRoleId());
  }

  @Transactional(rollbackFor = Exception.class)
  public Boolean removeRole(RemoveRoleCmd cmd) {
    return accountDomainService.removeRole(cmd.getActId(), cmd.getRoleId());
  }
}
