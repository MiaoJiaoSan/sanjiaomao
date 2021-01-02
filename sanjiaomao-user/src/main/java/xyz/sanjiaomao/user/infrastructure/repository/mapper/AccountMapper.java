package xyz.sanjiaomao.user.infrastructure.repository.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import xyz.sanjiaomao.user.infrastructure.repository.entity.AccountDO;

@Mapper
public interface AccountMapper {

  int insert(AccountDO accountDO);

  int update(AccountDO accountDO);

  AccountDO findById(Long id);

  AccountDO findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
