package xyz.sanjiaomao.user.domain.user.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import xyz.sanjiaomao.shared.autoconfiguration.snowflake.SnowflakeUtil;
import xyz.sanjiaomao.user.domain.user.assembler.ActUserRelDomainAssembler;
import xyz.sanjiaomao.user.domain.user.entity.Account;
import xyz.sanjiaomao.user.domain.user.entity.User;
import xyz.sanjiaomao.user.domain.user.entity.ActUserRel;
import xyz.sanjiaomao.user.domain.user.entity.UserAggregation;
import xyz.sanjiaomao.user.domain.user.event.SaveUserEvent;
import xyz.sanjiaomao.user.domain.user.repository.ActUserRelRepository;
import xyz.sanjiaomao.user.infrastructure.repository.entity.ActUserRelDO;

@Service
@Slf4j
public class ActUserRelDomainService {

  @Autowired
  private ActUserRelRepository actUserRelRepository;
  @Autowired
  private ActUserRelDomainAssembler actUserRelDomainAssembler;

  @EventListener
  public void listener(SaveUserEvent event){
    UserAggregation aggregation = event.getAggregation();
    Account account = aggregation.getAccount();
    User user = aggregation.getUser();
    ActUserRel actUserRel = new ActUserRel(SnowflakeUtil.USER_ACT_REL.nextId(), user.getId(), account.getId());
    ActUserRelDO actUserRelDO = actUserRelDomainAssembler.convert(actUserRel);
    actUserRelRepository.save(actUserRelDO);
  }





}
