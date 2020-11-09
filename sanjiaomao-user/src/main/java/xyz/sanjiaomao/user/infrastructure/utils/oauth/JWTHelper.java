package xyz.sanjiaomao.user.infrastructure.utils.oauth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import xyz.sanjiaomao.user.domain.user.entity.Account;

/**
 * jwt
 * @author lyf
 * @date 2020-11-09
 */
@Component("JWTHelper")
public class JWTHelper implements UserDetailsService {

  @Override
  public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
    Account accountObj = new Account();
    accountObj.setAccount(account);
    accountObj.setPassword("{bcrypt}$2a$10$mIWTpuy9jCcsuVCCRasevuWRGmYbfrfAMFQVzC9LqO4hQzezh3ld.");
    return accountObj;
  }
}
