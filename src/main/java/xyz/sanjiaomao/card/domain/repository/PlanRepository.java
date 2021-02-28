package xyz.sanjiaomao.card.domain.repository;

import xyz.sanjiaomao.card.domain.Plan;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-02-28 01:43
 */
public interface PlanRepository {
  Plan findByAccountId(Long accountId);

  Plan findByAccountIdAndFinished(Long accountId, String pending);

  void save(Plan plan);

  Plan findById(Long planId);
}
