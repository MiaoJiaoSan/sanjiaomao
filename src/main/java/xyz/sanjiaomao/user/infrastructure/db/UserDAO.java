package xyz.sanjiaomao.user.infrastructure.db;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<UserDO, Long> {
  UserDO findByAccount(String account);
}
