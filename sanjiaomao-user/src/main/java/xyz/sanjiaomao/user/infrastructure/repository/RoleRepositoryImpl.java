package xyz.sanjiaomao.user.infrastructure.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xyz.sanjiaomao.user.domain.role.Role;
import xyz.sanjiaomao.user.domain.role.repository.RoleRepository;
import xyz.sanjiaomao.user.infrastructure.assembler.RoleAssembler;
import xyz.sanjiaomao.user.infrastructure.repository.mapper.RoleMapper;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-01-01 19:17
 */
@Repository
public class RoleRepositoryImpl implements RoleRepository {

  @Autowired
  private RoleMapper roleMapper;

  @Autowired
  private RoleAssembler roleAssembler;

  public Boolean save(Role role) {
    roleMapper.insert(roleAssembler.convert(role));
    return true;
  }
}
