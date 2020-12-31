package xyz.sanjiaomao.user.infrastructure.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import xyz.sanjiaomao.user.domain.user.assembler.AccountDomainAssembler;
import xyz.sanjiaomao.user.domain.user.entity.Account;
import xyz.sanjiaomao.user.domain.user.entity.Role;
import xyz.sanjiaomao.user.domain.user.entity.UserAggregation;
import xyz.sanjiaomao.user.domain.user.repository.AccountRepository;
import xyz.sanjiaomao.user.infrastructure.repository.entity.AccountDO;
import xyz.sanjiaomao.user.infrastructure.repository.mapper.AccountMapper;

import java.util.List;
import java.util.Optional;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

  @Autowired
  private AccountMapper accountMapper;
  @Autowired
  private AccountDomainAssembler accountDomainAssembler;

  @Override
  @Transactional(rollbackFor = Exception.class)
  public AccountDO save(UserAggregation aggregation) {
    Account account = aggregation.getAccount();
    AccountDO accountDO = accountMapper.findById(account.getId());
    if(!Optional.ofNullable(accountDO).isPresent()){
      accountMapper.insert(accountDomainAssembler.convert(account));
    } else {
      accountDomainAssembler.convert(account, accountDO);
      accountMapper.update(accountDO);
    }
    return accountDO;
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public Account findActById(Long id) {
    AccountDO accountDO = accountMapper.findById(id);
    return accountDomainAssembler.convert(accountDO);
  }

  @Override
  public List<Role> findRoleById(Long id) {
    return null;
  }


}
