package xyz.sanjiaomao.user.domain.shared.repository;

import xyz.sanjiaomao.user.domain.role.Role;

import java.util.List;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-01-01 16:54
 */
public interface ActRoleRelRepository {


  List<Role> findRoleByActId(Long actId);

  Boolean save(Long actId, Long roleId);

  Boolean delete(Long actId, Long roleId);
}
