package xyz.sanjiaomao.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import xyz.sanjiaomao.auth.repository.AccountRepository;

/**
 * jwt
 *
 * @author lyf
 * @date 2020-11-09
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private AccountRepository accountRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return accountRepository.findByUsername(username);
  }
}
