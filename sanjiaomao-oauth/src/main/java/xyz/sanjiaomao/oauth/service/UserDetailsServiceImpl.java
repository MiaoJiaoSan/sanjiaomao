package xyz.sanjiaomao.oauth.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import xyz.sanjiaomao.oauth.entity.Account;

/**
 * jwt
 * @author lyf
 * @date 2020-11-09
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

  @Override
  public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
    Account accountObj = new Account();
    accountObj.setUsername("sanjiaomao");
    accountObj.setPassword("{bcrypt}$2a$10$mIWTpuy9jCcsuVCCRasevuWRGmYbfrfAMFQVzC9LqO4hQzezh3ld.");
    return accountObj;
  }
}
