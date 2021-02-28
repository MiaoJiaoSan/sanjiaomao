package xyz.sanjiaomao.card.infrastructure.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xyz.sanjiaomao.card.domain.Card;
import xyz.sanjiaomao.card.domain.repository.CardRepository;
import xyz.sanjiaomao.card.infrastructure.db.CardDAO;
import xyz.sanjiaomao.card.infrastructure.db.CardDO;
import xyz.sanjiaomao.card.infrastructure.facetory.CardConvert;

import java.util.Date;
import java.util.Optional;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-02-28 02:56
 */
@Repository
public class CardRepositoryImpl implements CardRepository {

  @Autowired
  private CardDAO cardDAO;

  @Override
  public Card findById(Long id) {
    Optional<CardDO> optional = cardDAO.findById(id);
    return optional.map(CardConvert::deserialize).orElse(null);
  }

  @Override
  public void save(Card card) {
    cardDAO.save(CardConvert.serialize(card));
  }

  @Override
  public Card findByPlanIdAndCardDate(Long planId, Date cardDate) {
    Optional<CardDO> optional = cardDAO.findByPlanIdAndCardDate(planId, cardDate);
    return optional.map(CardConvert::deserialize).orElse(null);
  }
}
