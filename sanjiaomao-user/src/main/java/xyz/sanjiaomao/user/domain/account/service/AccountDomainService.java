package xyz.sanjiaomao.user.domain.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.sanjiaomao.user.domain.account.Account;
import xyz.sanjiaomao.user.domain.account.event.AddRoleEvent;
import xyz.sanjiaomao.user.domain.account.event.RemoveRoleEvent;
import xyz.sanjiaomao.user.domain.account.repository.AccountRepository;
import xyz.sanjiaomao.user.domain.shared.repository.ActRoleRelRepository;

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
  private ActRoleRelRepository actRoleRelRepository;
  @Autowired
  private ApplicationEventPublisher eventPublisher;

  @Transactional(rollbackFor = Exception.class)
  public Boolean save(Account account) {
    accountRepository.save(account);
    return true;
  }

  @Transactional(rollbackFor = Exception.class)
  public Boolean modify(Account account) {
    accountRepository.modify(account);
    return true;
  }

  @Transactional(rollbackFor = Exception.class)
  public Boolean addRole(Long actId, Long roleId) {
    eventPublisher.publishEvent(new AddRoleEvent(actId, roleId));
    return true;
  }

  @Transactional(rollbackFor = Exception.class)
  public Boolean removeRole(Long actId, Long roleId) {
    eventPublisher.publishEvent(new RemoveRoleEvent(actId, roleId));
    return true;
  }


}
