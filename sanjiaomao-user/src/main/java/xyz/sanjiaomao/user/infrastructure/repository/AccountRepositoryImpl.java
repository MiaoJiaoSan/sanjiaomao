package xyz.sanjiaomao.user.infrastructure.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import xyz.sanjiaomao.user.domain.account.Account;
import xyz.sanjiaomao.user.domain.account.repository.AccountRepository;
import xyz.sanjiaomao.user.infrastructure.assembler.AccountAssembler;
import xyz.sanjiaomao.user.infrastructure.repository.entity.AccountDO;
import xyz.sanjiaomao.user.infrastructure.repository.mapper.AccountMapper;

import java.util.Optional;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

  @Autowired
  private AccountMapper accountMapper;

  @Autowired
  private AccountAssembler accountAssembler;


  @Override
  @Transactional(rollbackFor = Exception.class)
  public Boolean save(Account account) {
    accountMapper.insert(accountAssembler.convert(account));
    return true;
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public Boolean modify(Account account) {
    AccountDO accountDO = accountMapper.findById(account.getId());
    if (Optional.ofNullable(accountDO).isPresent()) {
      accountAssembler.convert(account, accountDO);
      accountMapper.update(accountDO);
    }
    return true;
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public Account findActById(Long id) {
    AccountDO accountDO = accountMapper.findById(id);
    return accountAssembler.convert(accountDO);
  }


}
