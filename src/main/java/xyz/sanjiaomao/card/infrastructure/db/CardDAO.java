package xyz.sanjiaomao.card.infrastructure.db;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.sanjiaomao.card.domain.Card;

import java.util.Date;
import java.util.Optional;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-02-28 00:38
 */
public interface CardDAO extends JpaRepository<CardDO, Long> {


  Optional<CardDO> findByPlanIdAndCardDate(Long planId, Date cardDate);
}
