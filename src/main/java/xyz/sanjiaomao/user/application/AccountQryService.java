package xyz.sanjiaomao.user.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.sanjiaomao.shared.constant.Token;
import xyz.sanjiaomao.shared.dto.AccountDTO;
import xyz.sanjiaomao.shared.dto.ResultDTO;
import xyz.sanjiaomao.user.domain.Account;
import xyz.sanjiaomao.user.infrastructure.dao.AccountDAO;
import xyz.sanjiaomao.user.infrastructure.factory.AccountFactory;
import xyz.sanjiaomao.user.infrastructure.repository.AccountRepository;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-02-27 00:33
 */
@Service
public class AccountQryService {

  @Autowired
  private AccountRepository accountRepository;
  @Autowired
  private AccountFactory accountFactory;

  public ResultDTO exist(String account){
    AccountDTO dto = findByAccount(account);
    boolean exist = Objects.isNull(dto);
    return new ResultDTO(exist?"":"账号已存在",exist);
  }

  @Transactional(rollbackFor = Exception.class, readOnly = true)
  public AccountDTO findByAccount(String account){
    AccountDAO dao = accountRepository.findByAccount(account);
    return accountFactory.convertDTO(dao);
  }

}
