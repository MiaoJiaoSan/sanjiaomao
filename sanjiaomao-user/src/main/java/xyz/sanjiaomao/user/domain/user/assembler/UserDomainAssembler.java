package xyz.sanjiaomao.user.domain.user.assembler;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import xyz.sanjiaomao.user.domain.user.entity.User;
import xyz.sanjiaomao.user.infrastructure.repository.entity.UserDO;

@Mapper(componentModel = "spring")
public interface UserDomainAssembler {

  User convert(UserDO userDO);

  UserDO convert(User user);

  void convert(User user, @MappingTarget UserDO userDO);
}
