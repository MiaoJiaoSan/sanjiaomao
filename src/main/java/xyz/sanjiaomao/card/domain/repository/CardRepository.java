package xyz.sanjiaomao.card.domain.repository;

import xyz.sanjiaomao.card.domain.Card;

import java.util.Date;
import java.util.List;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-02-28 01:00
 */
public interface CardRepository {

  Card findById(Long id);

  void save(Card card);

  Card findByPlanIdAndCardDate(Long planId, Date beginOfDay);
}
