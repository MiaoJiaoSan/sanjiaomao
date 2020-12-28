package xyz.sanjiaomao.user.domain.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.sanjiaomao.user.domain.user.assembler.UserDomainAssembler;
import xyz.sanjiaomao.user.domain.user.entity.User;
import xyz.sanjiaomao.user.domain.user.repository.UserRepository;
import xyz.sanjiaomao.user.infrastructure.repository.entity.UserDO;

import java.util.Objects;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2020-12-27 23:30
 */
@Service
public class UserDomainService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private UserDomainAssembler userDomainAssembler;


  public Boolean save(User user){
    UserDO userDO = userDomainAssembler.convert(user);
    userRepository.save(userDO);
    return Objects.nonNull(userDO.getId());
  }

}
