package xyz.sanjiaomao.user.application;

import cn.hutool.core.lang.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import xyz.sanjiaomao.shared.cmd.AccountEventCmd;
import xyz.sanjiaomao.shared.cmd.RegistryCmd;
import xyz.sanjiaomao.shared.snowflake.SnowflakeUtil;
import xyz.sanjiaomao.user.application.event.AccountEvent;
import xyz.sanjiaomao.user.domain.Account;
import xyz.sanjiaomao.user.domain.repository.AccountRepository;
import xyz.sanjiaomao.user.domain.service.AccountDomainService;

@Service
public class AccountCmdService {
  @Autowired
  private AccountDomainService accountDomainService;
  @Autowired
  private AccountRepository accountRepository;
  @Autowired
  private ApplicationEventPublisher applicationEventPublisher;

  public void accountRegistry(RegistryCmd cmd) {
    Assert.isNull(accountRepository.findByUsername(cmd.getUsername()), "用户名已存在");

    Account account = Account.newAccount(SnowflakeUtil.ACCOUNT.nextId(), cmd.getUsername(),
        accountDomainService.encryption(cmd.getPassword()), cmd.getNickname());

    account.checkPassword(accountDomainService.encryption(cmd.getRePassword()));
    accountRepository.save(account);
    applicationEventPublisher.publishEvent(new AccountEvent(account, account.getPassword()));
  }

  public void loginEvent(AccountEventCmd cmd) {
    Account account = accountRepository.findByUsername(cmd.getUsername());
    applicationEventPublisher.publishEvent(new AccountEvent(account, accountDomainService.encryption(cmd.getPassword())));
  }



}
