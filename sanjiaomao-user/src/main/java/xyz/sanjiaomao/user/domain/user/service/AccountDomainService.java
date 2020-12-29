package xyz.sanjiaomao.user.domain.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.sanjiaomao.user.domain.user.assembler.AccountDomainAssembler;
import xyz.sanjiaomao.user.domain.user.entity.UserAggregation;
import xyz.sanjiaomao.user.domain.user.repository.AccountRepository;
import xyz.sanjiaomao.user.infrastructure.repository.entity.AccountDO;

import java.util.Objects;

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
  private AccountDomainAssembler accountDomainAssembler;

  @Autowired
  private AccountRepository accountRepository;

  @Transactional
  public Boolean save(UserAggregation aggregation) {
    AccountDO accountDO = accountDomainAssembler.convert(aggregation.getAccount());
    accountRepository.save(accountDO);
    return Objects.nonNull(accountDO.getId());
  }

}
