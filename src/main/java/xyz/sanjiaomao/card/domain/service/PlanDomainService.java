package xyz.sanjiaomao.card.domain.service;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Assert;
import org.springframework.stereotype.Service;
import xyz.sanjiaomao.card.domain.Card;
import xyz.sanjiaomao.card.domain.Plan;

import java.util.Date;
import java.util.Objects;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-02-28 01:41
 */
@Service
public class PlanDomainService {


  public void isCreate(Plan plan){
    Assert.isNull(plan,"计划未完成,不能制定新计划");
  }

  public void modifyCardRemark(Card card, String remark) {
    card.setRemark(remark);
  }

  public void isModifyRemark(Card card) {
    DateTime dateTime = DateUtil.beginOfDay(new Date());
    Assert.isTrue(Objects.equals(dateTime, card.getStart()),"不能修改");
  }
}
