package xyz.sanjiaomao.user.infrastructure.db;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDAO extends JpaRepository<AccountDO, Long> {

  AccountDO findByUsername(String account);
}
