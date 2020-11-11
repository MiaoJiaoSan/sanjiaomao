package xyz.sanjiaomao.oauth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.sanjiaomao.oauth.entity.Account;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2020-11-11 13:37
 */
public interface AccountRepository extends JpaRepository<Account, Long> {

  Account findByUsername(String username);
}
