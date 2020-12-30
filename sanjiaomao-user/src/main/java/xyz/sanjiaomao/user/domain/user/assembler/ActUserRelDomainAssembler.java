package xyz.sanjiaomao.user.domain.user.assembler;

import org.mapstruct.Mapper;
import xyz.sanjiaomao.user.domain.user.entity.ActUserRel;
import xyz.sanjiaomao.user.infrastructure.repository.entity.ActUserRelDO;

@Mapper(componentModel = "spring")
public interface ActUserRelDomainAssembler {
  ActUserRelDO convert(ActUserRel actUserRel);
}
