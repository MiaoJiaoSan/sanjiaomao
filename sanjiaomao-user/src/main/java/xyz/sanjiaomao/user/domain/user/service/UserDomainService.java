package xyz.sanjiaomao.user.domain.user.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.sanjiaomao.shared.autoconfiguration.snowflake.SnowflakeUtil;
import xyz.sanjiaomao.user.domain.user.assembler.UserDomainAssembler;
import xyz.sanjiaomao.user.domain.user.entity.Account;
import xyz.sanjiaomao.user.domain.user.entity.User;
import xyz.sanjiaomao.user.domain.user.entity.UserAggregation;
import xyz.sanjiaomao.user.domain.user.event.SaveUserEvent;
import xyz.sanjiaomao.user.domain.user.repository.ActUserRelRepository;
import xyz.sanjiaomao.user.domain.user.repository.UserRepository;
import xyz.sanjiaomao.user.infrastructure.repository.entity.ActUserRelDO;
import xyz.sanjiaomao.user.infrastructure.repository.entity.UserDO;

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
@Slf4j
public class UserDomainService {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private ActUserRelRepository actUserRelRepository;
  @Autowired
  private ApplicationEventPublisher eventPublisher;


  @Transactional(rollbackFor = Exception.class)
  public Boolean save(User user, Long actId){
    UserAggregation aggregation = new UserAggregation();
    aggregation.save(user);
    aggregation.save(new Account(actId));
    userRepository.save(aggregation);
    eventPublisher.publishEvent(new SaveUserEvent(aggregation));
    return true;
  }

  @EventListener
  public void listener(SaveUserEvent event){
    UserAggregation aggregation = event.getAggregation();
    Account account = aggregation.getAccount();
    User user = aggregation.getUser();
    ActUserRelDO actUserRelDO = new ActUserRelDO();
    actUserRelDO.setId(SnowflakeUtil.USER_ACT_REL.nextId());
    actUserRelDO.setActId(account.getId());
    actUserRelDO.setUserId(user.getId());
    actUserRelRepository.save(actUserRelDO);
  }

}
