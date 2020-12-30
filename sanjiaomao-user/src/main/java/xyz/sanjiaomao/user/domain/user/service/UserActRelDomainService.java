package xyz.sanjiaomao.user.domain.user.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import xyz.sanjiaomao.user.domain.user.assembler.UserActRelDomainAssembler;
import xyz.sanjiaomao.user.domain.user.entity.Account;
import xyz.sanjiaomao.user.domain.user.entity.User;
import xyz.sanjiaomao.user.domain.user.entity.UserActRel;
import xyz.sanjiaomao.user.domain.user.entity.UserAggregation;
import xyz.sanjiaomao.user.domain.user.event.SaveUserEvent;
import xyz.sanjiaomao.user.domain.user.repository.UserActRelRepository;
import xyz.sanjiaomao.user.infrastructure.repository.entity.UserActRelDO;

@Service
@Slf4j
public class UserActRelDomainService {

  @Autowired
  private UserActRelRepository userActRelRepository;
  @Autowired
  private UserActRelDomainAssembler userActRelDomainAssembler;

  @EventListener
  public void listener(SaveUserEvent event){
    UserAggregation aggregation = event.getAggregation();
    Account account = aggregation.getAccount();
    User user = aggregation.getUser();
    UserActRel userActRel = new UserActRel(null, user.getId(), account.getId());
    UserActRelDO userActRelDO = userActRelDomainAssembler.convert(userActRel);
    userActRelRepository.save(userActRelDO);
  }





}
