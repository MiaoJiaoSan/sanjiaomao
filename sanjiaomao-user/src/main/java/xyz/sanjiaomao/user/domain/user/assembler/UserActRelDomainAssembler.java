package xyz.sanjiaomao.user.domain.user.assembler;

import org.mapstruct.Mapper;
import xyz.sanjiaomao.user.domain.user.entity.UserActRel;
import xyz.sanjiaomao.user.infrastructure.repository.entity.UserActRelDO;

@Mapper(componentModel = "spring")
public interface UserActRelDomainAssembler {
  UserActRelDO convert(UserActRel userActRel);
}
