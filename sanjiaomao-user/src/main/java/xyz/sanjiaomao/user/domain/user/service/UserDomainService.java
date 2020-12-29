package xyz.sanjiaomao.user.domain.user.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.sanjiaomao.user.domain.user.assembler.UserDomainAssembler;
import xyz.sanjiaomao.user.domain.user.entity.User;
import xyz.sanjiaomao.user.domain.user.entity.UserAggregation;
import xyz.sanjiaomao.user.domain.user.event.SaveUserEvent;
import xyz.sanjiaomao.user.domain.user.repository.UserRepository;
import xyz.sanjiaomao.user.infrastructure.repository.entity.UserDO;

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
  private UserDomainAssembler userDomainAssembler;

  @Autowired
  private ApplicationEventPublisher eventPublisher;


  @Transactional
  public Long save(UserAggregation aggregation){
    log.info("====================="+Thread.currentThread().getId());
    UserDO userDO = userDomainAssembler.convert(aggregation.getUser());
    userDO = userRepository.save(userDO);
    User user = userDomainAssembler.convert(userDO);
    aggregation.setUser(user);
    eventPublisher.publishEvent(new SaveUserEvent(aggregation));
    return userDO.getId();
  }

}
