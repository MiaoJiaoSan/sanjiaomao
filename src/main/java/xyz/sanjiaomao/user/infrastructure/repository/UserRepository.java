package xyz.sanjiaomao.user.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.sanjiaomao.user.infrastructure.dao.UserDAO;

public interface UserRepository extends JpaRepository<UserDAO, Long> {
  UserDAO findByAccount(String account);
}
