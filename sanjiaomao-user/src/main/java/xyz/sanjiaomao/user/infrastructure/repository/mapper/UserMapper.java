package xyz.sanjiaomao.user.infrastructure.repository.mapper;

import xyz.sanjiaomao.user.infrastructure.repository.entity.UserDO;

public interface UserMapper {

  int insert(UserDO user);

  int update(UserDO user);

  UserDO findById(Long id);

  UserDO findByIdCard(String idCard);

}
