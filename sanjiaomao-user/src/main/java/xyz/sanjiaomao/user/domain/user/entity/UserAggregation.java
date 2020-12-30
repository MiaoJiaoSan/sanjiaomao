package xyz.sanjiaomao.user.domain.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import xyz.sanjiaomao.shared.autoconfiguration.snowflake.SnowflakeUtil;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2020-12-29 12:57
 */
@Getter
@NoArgsConstructor
public class UserAggregation {

  private Account account;

  private User user;

  private List<Role> roles;

  public void save(User user) {
    this.user = user;
    Long id = this.user.getId();
    this.user.setId(Optional.ofNullable(id).orElse(SnowflakeUtil.USER.nextId()));
  }

  public void save(Account account) {
    this.account = account;
    Long id = this.account.getId();
    this.account.setId(Optional.ofNullable(id).orElse(SnowflakeUtil.ACCOUNT.nextId()));
  }

  public void save(List<Role> roles) {
    this.roles = roles;
  }

  public void addRole(Role role) {
    if(roles.stream().noneMatch(r-> Objects.equals(r.getId(), role.getId()))){
      roles.add(role);
    }
  }
}
