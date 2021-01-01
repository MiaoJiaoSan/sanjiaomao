package xyz.sanjiaomao.user.infrastructure.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import xyz.sanjiaomao.user.domain.account.event.AddRoleEvent;
import xyz.sanjiaomao.user.domain.account.event.RemoveRoleEvent;
import xyz.sanjiaomao.user.domain.role.Role;
import xyz.sanjiaomao.user.domain.shared.repository.ActRoleRelRepository;
import xyz.sanjiaomao.user.infrastructure.assembler.RoleAssembler;
import xyz.sanjiaomao.user.infrastructure.repository.entity.ActRoleRelDO;
import xyz.sanjiaomao.user.infrastructure.repository.entity.RoleDO;
import xyz.sanjiaomao.user.infrastructure.repository.mapper.ActRoleRelMapper;
import xyz.sanjiaomao.user.infrastructure.repository.mapper.RoleMapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-01-01 16:55
 */
@Repository
public class ActRoleRelRepositoryImpl implements ActRoleRelRepository {

  @Autowired
  private ActRoleRelMapper actRoleRelMapper;
  @Autowired
  private RoleMapper roleMapper;
  @Autowired
  private RoleAssembler roleAssembler;

  @Override
  @Transactional(rollbackFor = Exception.class)
  public List<Role> findRoleByActId(Long actId) {
    List<ActRoleRelDO> roleRelations = actRoleRelMapper.findByActId(actId);
    List<Long> roleIds = roleRelations.stream().map(ActRoleRelDO::getRoleId).collect(Collectors.toList());
    List<RoleDO> roles = roleMapper.findByIds(roleIds);
    return roleAssembler.convert(roles);
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public Boolean save(Long actId, Long roleId) {
    List<ActRoleRelDO> relations = actRoleRelMapper.findByActId(actId);
    if (relations.stream().noneMatch(relation -> Objects.equals(relation.getRoleId(), roleId))) {
      ActRoleRelDO actRoleRelDO = new ActRoleRelDO();
      actRoleRelDO.setRoleId(roleId);
      actRoleRelDO.setActId(actId);
      actRoleRelMapper.insert(actRoleRelDO);
    }
    return true;
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public Boolean delete(Long actId, Long roleId) {
    ActRoleRelDO actRoleRelDO = actRoleRelMapper.findByActIdAndRoleId(actId, roleId);
    actRoleRelMapper.deleteById(actRoleRelDO.getId());
    return true;
  }

  @EventListener
  @Transactional(rollbackFor = Exception.class)
  public void listener(AddRoleEvent addRoleEvent) {
    save(addRoleEvent.getActId(), addRoleEvent.getRoleId());
  }


  @EventListener
  @Transactional(rollbackFor = Exception.class)
  public void listener(RemoveRoleEvent removeRoleEvent) {
    delete(removeRoleEvent.getActId(), removeRoleEvent.getRoleId());
  }
}
