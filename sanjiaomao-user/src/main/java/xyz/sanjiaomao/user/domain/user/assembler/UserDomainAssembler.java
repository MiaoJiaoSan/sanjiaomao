package xyz.sanjiaomao.user.domain.user.assembler;

import org.mapstruct.Mapper;
import xyz.sanjiaomao.user.domain.user.entity.User;
import xyz.sanjiaomao.user.infrastructure.repository.entity.UserDO;

@Mapper(componentModel = "spring")
public interface UserDomainAssembler {
  UserDO convert(User user);
}
