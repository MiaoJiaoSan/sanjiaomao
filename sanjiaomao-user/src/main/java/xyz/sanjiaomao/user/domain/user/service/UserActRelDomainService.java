package xyz.sanjiaomao.user.domain.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.sanjiaomao.user.domain.user.assembler.UserActRelDomainAssembler;
import xyz.sanjiaomao.user.domain.user.entity.UserActRel;
import xyz.sanjiaomao.user.domain.user.repository.UserActRelRepository;
import xyz.sanjiaomao.user.infrastructure.repository.entity.UserActRelDO;

import java.util.Objects;

@Service
public class UserActRelDomainService {

  @Autowired
  private UserActRelRepository userActRelRepository;

  @Autowired
  private UserActRelDomainAssembler userActRelDomainAssembler;


  public Boolean save(UserActRel userActRel){
    UserActRelDO userActRelDO = userActRelDomainAssembler.convert(userActRel);
    userActRelRepository.save(userActRelDO);
    return Objects.nonNull(userActRel.getId());
  }


}
