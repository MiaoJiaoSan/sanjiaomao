package xyz.sanjiaomao.user.infrastructure.repository.mapper;

import org.apache.ibatis.annotations.Mapper;
import xyz.sanjiaomao.user.infrastructure.repository.entity.UserDO;

@Mapper
public interface UserMapper {

  int insert(UserDO userDO);

  int update(UserDO userDO);

  UserDO findById(Long id);

  UserDO findByIdCard(String idCard);

}
