package xyz.sanjiaomao.user.infrastructure.factory;

import xyz.sanjiaomao.user.domain.User;
import xyz.sanjiaomao.user.infrastructure.dao.UserDAO;

public interface UserFactory {


  static User load(UserDAO dao){
    return new User(null,null,null);
  }
}
