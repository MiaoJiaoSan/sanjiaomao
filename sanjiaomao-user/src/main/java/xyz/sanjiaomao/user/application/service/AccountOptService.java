package xyz.sanjiaomao.user.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.sanjiaomao.shared.autoconfiguration.snowflake.SnowflakeUtil;
import xyz.sanjiaomao.user.application.cmd.opt.SaveActCmd;
import xyz.sanjiaomao.user.domain.user.entity.Account;
import xyz.sanjiaomao.user.domain.user.entity.UserAggregation;
import xyz.sanjiaomao.user.domain.user.service.AccountDomainService;

import java.util.Optional;

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

  @Transactional
  public Boolean save(SaveActCmd cmd) {
    Account account = new Account(Optional.ofNullable(cmd.getId()).orElse(SnowflakeUtil.ACCOUNT.nextId()),
        cmd.getUsername(), cmd.getPassword(), cmd.getNickname(), cmd.getEmail(), cmd.getPhone());
    accountDomainService.save(new UserAggregation(account, null));
    return true;
  }

}
