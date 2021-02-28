package xyz.sanjiaomao.card.infrastructure.facetory;

import org.mapstruct.Mapper;
import xyz.sanjiaomao.card.domain.Card;
import xyz.sanjiaomao.card.domain.Plan;
import xyz.sanjiaomao.card.infrastructure.db.CardDO;
import xyz.sanjiaomao.card.infrastructure.db.PlanDO;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-02-28 03:05
 */
@Mapper(componentModel = "spring")
public interface CardConvert {

  static CardDO serialize(Card card){
    CardDO cardDO = new CardDO();
    cardDO.setId(card.getId());
    cardDO.setPlanId(card.getPlanId());
    cardDO.setCardDate(card.getCardDate());
    cardDO.setStart(card.getStart());
    cardDO.setEnd(card.getEnd());
    cardDO.setRemark(card.getRemark());
    return cardDO;
  }

  static Card deserialize(CardDO cardDO){
    Card card = Card.newCard(cardDO.getId(), cardDO.getPlanId(), cardDO.getCardDate(), cardDO.getStart(),
        cardDO.getRemark());
    card.setEnd(card.getEnd());
    return card;
  }
}
