package xyz.sanjiaomao.auth.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * account
 *
 * @author lyf
 * @date 2020-11-09
 */
@Data
@Entity(name = "account")
public class Account implements UserDetails, Serializable {
  /**
   * id
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  /**
   * 账号
   */
  @Column(columnDefinition = "username")
  private String username;
  /**
   * 密码
   */
  @Column(columnDefinition = "password")
  private String password;


  @Column(columnDefinition = "non_expired")
  private Boolean nonExpired;

  @Column(columnDefinition = "credentials_non_expired")
  private Boolean credentialsNonExpired;

  @Column(columnDefinition = "non_locked")
  private Boolean nonLocked;

  @Column(columnDefinition = "enable")
  private Boolean enable;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return nonExpired;
  }

  @Override
  public boolean isAccountNonLocked() {
    return nonLocked;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return credentialsNonExpired;
  }

  @Override
  public boolean isEnabled() {
    return enable;
  }
}
