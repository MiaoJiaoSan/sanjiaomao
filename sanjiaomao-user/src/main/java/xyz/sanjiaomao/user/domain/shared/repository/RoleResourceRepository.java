package xyz.sanjiaomao.user.domain.shared.repository;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-01-01 20:22
 */
public interface RoleResourceRepository {


  Boolean save(Long roleId, Long resourceId, Integer privilege);

  Boolean modify(Long roleId, Long resourceId, Integer privilege);
}
