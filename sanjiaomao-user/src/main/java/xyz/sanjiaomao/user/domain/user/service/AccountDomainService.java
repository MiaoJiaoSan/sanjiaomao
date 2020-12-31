package xyz.sanjiaomao.user.domain.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.sanjiaomao.shared.autoconfiguration.snowflake.SnowflakeUtil;
import xyz.sanjiaomao.user.domain.user.assembler.AccountDomainAssembler;
import xyz.sanjiaomao.user.domain.user.entity.Account;
import xyz.sanjiaomao.user.domain.user.entity.Role;
import xyz.sanjiaomao.user.domain.user.entity.User;
import xyz.sanjiaomao.user.domain.user.entity.UserAggregation;
import xyz.sanjiaomao.user.domain.user.event.AddRoleEvent;
import xyz.sanjiaomao.user.domain.user.event.SaveUserEvent;
import xyz.sanjiaomao.user.domain.user.repository.AccountRepository;
import xyz.sanjiaomao.user.domain.user.repository.ActUserRelRepository;
import xyz.sanjiaomao.user.infrastructure.repository.entity.AccountDO;
import xyz.sanjiaomao.user.infrastructure.repository.entity.ActUserRelDO;

import java.util.List;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2020-12-27 23:32
 */
@Service
public class AccountDomainService {





  @Autowired
  private AccountRepository accountRepository;
  @Autowired
  private ApplicationEventPublisher eventPublisher;

  @Transactional(rollbackFor = Exception.class)
  public Boolean save(Account account) {
    UserAggregation aggregation = new UserAggregation();
    aggregation.save(account);
    accountRepository.save(aggregation);
    return true;
  }

  @Transactional(rollbackFor = Exception.class)
  public Boolean addRole(Account account, Role role){
    UserAggregation aggregation = new UserAggregation();
    account = accountRepository.findActById(account.getId());
    List<Role> roles = accountRepository.findRoleById(account.getId());
    aggregation.save(account);
    aggregation.save(roles);
    aggregation.addRole(role);
    eventPublisher.publishEvent(new AddRoleEvent(aggregation));
    return true;
  }


  @EventListener
  @Transactional(rollbackFor = Exception.class)
  public void listener(AddRoleEvent addRoleEvent){
    UserAggregation aggregation = addRoleEvent.getAggregation();
    Account account = aggregation.getAccount();
    List<Role> roles = aggregation.getRoles();

  }





}
