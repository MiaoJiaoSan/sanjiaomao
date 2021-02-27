package xyz.sanjiaomao.user.application;

import cn.hutool.core.lang.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import xyz.sanjiaomao.shared.cmd.AddUserCmd;
import xyz.sanjiaomao.shared.cmd.ModifyUserCmd;
import xyz.sanjiaomao.shared.snowflake.SnowflakeUtil;
import xyz.sanjiaomao.user.domain.User;
import xyz.sanjiaomao.user.domain.repository.UserRepository;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-02-27 16:41
 */
@Service
public class UserCmdService {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private ApplicationEventPublisher applicationEventPublisher;


  public void addUser(AddUserCmd cmd) {

    Assert.isNull(userRepository.findByAccountId(cmd.getAccountId()), "用户已存在");

    User user = User.newUser(SnowflakeUtil.USER.nextId(), cmd.getAccountId(),
        cmd.getName(), cmd.getAge(), cmd.getGender(), cmd.getIdCard(), cmd.getMobile(), cmd.getEmail());

    userRepository.save(user);
  }

  public void modify(Long id, ModifyUserCmd cmd) {
    User user = userRepository.findById(id);

    Assert.notNull(user, "用户不存在");

    user.modify(cmd.getAge(), cmd.getGender(), cmd.getMobile(), cmd.getEmail());
    userRepository.save(user);
  }
}
