package xyz.sanjiaomao.user.domain.user.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.sanjiaomao.user.domain.shared.repository.UserActRelRepository;
import xyz.sanjiaomao.user.domain.user.User;
import xyz.sanjiaomao.user.domain.user.event.SaveUserEvent;
import xyz.sanjiaomao.user.domain.user.repository.UserRepository;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2020-12-27 23:30
 */
@Service
@Slf4j
public class UserDomainService {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private UserActRelRepository userActRelRepository;
  @Autowired
  private ApplicationEventPublisher eventPublisher;


  @Transactional(rollbackFor = Exception.class)
  public Boolean save(User user, Long actId) {
    userRepository.save(user);
    eventPublisher.publishEvent(new SaveUserEvent(user.getId(), actId));
    return true;
  }

  @Transactional(rollbackFor = Exception.class)
  public Boolean modify(User user) {
    return userRepository.modify(user);
  }


}
