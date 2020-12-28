package xyz.sanjiaomao.user.domain.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.sanjiaomao.user.domain.user.entity.Account;

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
public class AccountOptDomainService {



  @Transactional
  public Boolean save(Account account) {
//    Account save = accountRepository.save(account);
//    return Objects.nonNull(save.getId());
    return null;
  }

}
