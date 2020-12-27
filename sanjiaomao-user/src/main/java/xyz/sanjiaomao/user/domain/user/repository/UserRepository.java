package xyz.sanjiaomao.user.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.sanjiaomao.user.domain.user.entity.User;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2020-12-27 23:11
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
