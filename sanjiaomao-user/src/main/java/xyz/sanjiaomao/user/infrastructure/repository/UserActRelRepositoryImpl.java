package xyz.sanjiaomao.user.infrastructure.repository;

import org.springframework.stereotype.Repository;
import xyz.sanjiaomao.user.domain.user.repository.UserActRelRepository;
import xyz.sanjiaomao.user.infrastructure.repository.entity.UserActRelDO;

@Repository
public class UserActRelRepositoryImpl implements UserActRelRepository {
  @Override
  public UserActRelDO save(UserActRelDO rel) {
    return null;
  }
}
