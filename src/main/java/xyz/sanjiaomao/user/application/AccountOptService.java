package xyz.sanjiaomao.user.application;

import cn.hutool.core.lang.Assert;
import cn.hutool.crypto.digest.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import xyz.sanjiaomao.shared.cmd.LoginCmd;
import xyz.sanjiaomao.shared.cmd.RegistryCmd;
import xyz.sanjiaomao.shared.snowflake.SnowflakeUtil;
import xyz.sanjiaomao.user.application.event.LoginEvent;
import xyz.sanjiaomao.user.domain.Account;
import xyz.sanjiaomao.user.domain.repository.AccountRepository;

@Service
public class AccountOptService {
  @Autowired
  private AccountRepository accountRepository;
  @Autowired
  private ApplicationEventPublisher applicationEventPublisher;

  public void accountRegistry(RegistryCmd cmd) {
    Assert.isNull(accountRepository.findByUsername(cmd.getUsername()),"用户名已存在");

    Account account = Account.newAccount(SnowflakeUtil.ACCOUNT.nextId(), cmd.getUsername(),
        encryption(cmd.getPassword()), cmd.getNickname());

    account.checkPassword(encryption(cmd.getRePassword()), account);
    accountRepository.save(account);
    applicationEventPublisher.publishEvent(new LoginEvent<Account>(account));
  }

  public void accountLogin(LoginCmd cmd) {
    Account account = accountRepository.findByUsername(cmd.getUsername());
    account.checkPassword(encryption(cmd.getPassword()), account);
    applicationEventPublisher.publishEvent(new LoginEvent<Account>(account));
  }


  private String encryption(String source) {
    MD5 md5 = MD5.create();
    return md5.digestHex(source);
  }
}
