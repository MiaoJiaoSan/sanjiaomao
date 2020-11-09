package xyz.sanjiaomao.user.domain.user.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;

/**
 * account
 * @author lyf
 * @date 2020-11-09
 */
@Data
public class Account implements UserDetails, Serializable {
  /**
   * id
   */
  private Long id;
  /**
   * 账号
   */
  private String account;
  /**
   * 密码
   */
  private String password;
  /**
   * refreshToken
   */
  private String refreshToken;


  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  @Override
  public String getUsername() {
    return account;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
