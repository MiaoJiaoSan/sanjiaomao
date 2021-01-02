package xyz.sanjiaomao.user.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.sanjiaomao.shared.dto.AccountDTO;
import xyz.sanjiaomao.user.application.cmd.qry.UsernameAndPwdQryCmd;
import xyz.sanjiaomao.user.infrastructure.assembler.AccountAssembler;
import xyz.sanjiaomao.user.infrastructure.repository.entity.AccountDO;
import xyz.sanjiaomao.user.infrastructure.repository.mapper.AccountMapper;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-01-02 13:07
 */
@Service
public class AccountQryService {

  @Autowired
  private AccountMapper accountMapper;

  @Autowired
  private AccountAssembler accountAssembler;

  @Transactional
  public AccountDTO findByUsernameAndPassword(UsernameAndPwdQryCmd cmd) {
    AccountDO accountDO = accountMapper.findByUsernameAndPassword(cmd.getUsername(), cmd.getPassword());
    return accountAssembler.convert2dto(accountDO);
  }
}
