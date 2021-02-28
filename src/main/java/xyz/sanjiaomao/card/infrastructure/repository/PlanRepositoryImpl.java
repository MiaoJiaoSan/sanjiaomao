package xyz.sanjiaomao.card.infrastructure.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xyz.sanjiaomao.card.domain.Plan;
import xyz.sanjiaomao.card.domain.repository.PlanRepository;
import xyz.sanjiaomao.card.infrastructure.db.PlanDAO;
import xyz.sanjiaomao.card.infrastructure.db.PlanDO;
import xyz.sanjiaomao.card.infrastructure.facetory.PlanConvert;

import java.util.Optional;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-02-28 03:01
 */
@Repository
public class PlanRepositoryImpl implements PlanRepository {

  @Autowired
  private PlanDAO planDAO;

  @Override
  public Plan findByAccountId(Long accountId) {
    Optional<PlanDO> optional = planDAO.findByAccountId(accountId);
    return optional.map(PlanConvert::deserialize).orElse(null);
  }

  @Override
  public Plan findByAccountIdAndFinished(Long accountId, String finished) {
    Optional<PlanDO> optional = planDAO.findByAccountIdAndFinished(accountId, finished);
    return optional.map(PlanConvert::deserialize).orElse(null);
  }

  @Override
  public void save(Plan plan) {
    PlanDO serialize = PlanConvert.serialize(plan);
    planDAO.save(serialize);
  }

  @Override
  public Plan findById(Long id) {
    Optional<PlanDO> optional = planDAO.findById(id);

    return null;
  }
}
