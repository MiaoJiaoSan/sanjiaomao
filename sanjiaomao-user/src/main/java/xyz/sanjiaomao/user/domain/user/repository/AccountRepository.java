package xyz.sanjiaomao.user.domain.user.repository;

import xyz.sanjiaomao.user.domain.user.entity.Account;
import xyz.sanjiaomao.user.domain.user.entity.Role;
import xyz.sanjiaomao.user.domain.user.entity.UserAggregation;
import xyz.sanjiaomao.user.infrastructure.repository.entity.AccountDO;

import java.util.List;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2020-12-27 23:10
 */
public interface AccountRepository {

  AccountDO save(UserAggregation aggregation);

  Account findActById(Long id);

  List<Role> findRoleById(Long id);
}
