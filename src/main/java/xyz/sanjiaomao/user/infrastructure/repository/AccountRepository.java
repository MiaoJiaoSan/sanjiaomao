package xyz.sanjiaomao.user.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.sanjiaomao.user.infrastructure.dao.AccountDAO;

public interface AccountRepository extends JpaRepository<AccountDAO, Long> {

  AccountDAO findByAccount(String account);
}
