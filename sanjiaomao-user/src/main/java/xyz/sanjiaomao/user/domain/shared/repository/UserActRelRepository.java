package xyz.sanjiaomao.user.domain.shared.repository;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2020-12-27 23:22
 */
public interface UserActRelRepository {


  Boolean save(Long userId, Long actId);
}
