package xyz.sanjiaomao.user.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.sanjiaomao.shared.snowflake.SnowflakeUtil;
import xyz.sanjiaomao.user.application.cmd.opt.ModifyUserCmd;
import xyz.sanjiaomao.user.application.cmd.opt.SaveUserCmd;
import xyz.sanjiaomao.user.domain.user.User;
import xyz.sanjiaomao.user.domain.user.service.UserDomainService;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2020-12-27 23:30
 */
@Service
public class UserOptService {
  @Autowired
  private UserDomainService userDomainService;


  @Transactional(rollbackFor = Exception.class)
  public Boolean save(SaveUserCmd cmd) {
    User user = new User(SnowflakeUtil.USER.nextId(), cmd.getName(), cmd.getAge(), cmd.getGender(), cmd.getIdCard());
    return userDomainService.save(user, cmd.getActId());
  }

  @Transactional(rollbackFor = Exception.class)
  public Boolean modify(ModifyUserCmd cmd) {
    User user = new User(cmd.getId(), cmd.getName(), cmd.getAge(), cmd.getGender(), cmd.getIdCard());
    return userDomainService.modify(user);
  }

}
