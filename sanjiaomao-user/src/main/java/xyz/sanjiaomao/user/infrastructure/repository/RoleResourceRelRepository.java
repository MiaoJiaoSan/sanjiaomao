package xyz.sanjiaomao.user.infrastructure.repository;

import org.springframework.stereotype.Repository;
import xyz.sanjiaomao.user.domain.shared.repository.RoleResourceRepository;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-01-01 20:30
 */
@Repository
public class RoleResourceRelRepository implements RoleResourceRepository {


  @Override
  public Boolean save(Long roleId, Long resourceId, Integer privilege) {
    return null;
  }

  @Override
  public Boolean modify(Long roleId, Long resourceId, Integer privilege) {
    return null;
  }
}
