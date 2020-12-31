package xyz.sanjiaomao.user.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.sanjiaomao.shared.autoconfiguration.snowflake.SnowflakeUtil;
import xyz.sanjiaomao.user.application.cmd.opt.SaveUserCmd;
import xyz.sanjiaomao.user.domain.user.entity.Account;
import xyz.sanjiaomao.user.domain.user.entity.User;
import xyz.sanjiaomao.user.domain.user.entity.UserAggregation;
import xyz.sanjiaomao.user.domain.user.service.UserDomainService;

import java.util.Optional;

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
  public Boolean save(SaveUserCmd cmd){
    User user = new User(cmd.getId(), cmd.getName(), cmd.getAge(), cmd.getGender(), cmd.getIdCard());
    userDomainService.save(user, cmd.getActId());
    return true;
  }
}
