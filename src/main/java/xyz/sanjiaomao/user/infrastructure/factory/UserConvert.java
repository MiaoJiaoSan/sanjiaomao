package xyz.sanjiaomao.user.infrastructure.factory;

import org.mapstruct.Mapper;
import xyz.sanjiaomao.user.domain.User;
import xyz.sanjiaomao.user.infrastructure.db.UserDO;

import java.util.Objects;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-02-27 18:23
 */
@Mapper(componentModel = "spring")
public interface UserConvert {

  static UserDO serialize(User user) {
    UserDO userDO = new UserDO();
    userDO.setId(user.getId());
    userDO.setAccountId(user.getAccountId());
    userDO.setName(user.getName());
    userDO.setAge(user.getAge());
    userDO.setGender(user.getGender());
    userDO.setIdCard(user.getIdCard());
    userDO.setMobile(user.getEmail());
    userDO.setEmail(user.getEmail());
    return userDO;
  }

  static User deserialize(UserDO userDO) {
    return User.newUser(userDO.getId(), userDO.getAccountId(),
        userDO.getName(), userDO.getAge(), userDO.getGender(), userDO.getIdCard(), userDO.getMobile(), userDO.getEmail());
  }
}
