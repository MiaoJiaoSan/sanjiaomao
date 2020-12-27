package xyz.sanjiaomao.user.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.sanjiaomao.user.domain.user.entity.Account;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2020-12-27 23:10
 */
public interface AccountRepository extends JpaRepository<Account, Long> {

  Account findAccountByUsernameAndPassword(String username, String password);
}
