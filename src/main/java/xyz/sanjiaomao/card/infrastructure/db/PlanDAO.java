package xyz.sanjiaomao.card.infrastructure.db;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-02-28 03:00
 */
public interface PlanDAO extends JpaRepository<PlanDO, Long> {
  Optional<PlanDO> findByAccountId(Long accountId);

  Optional<PlanDO> findByAccountIdAndFinished(Long accountId, String finished);
}
