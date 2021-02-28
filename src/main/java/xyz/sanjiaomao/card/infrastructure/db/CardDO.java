package xyz.sanjiaomao.card.infrastructure.db;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-02-28 00:38
 */
@Data
@Entity(name = "card")
public class CardDO {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "custom-uuid")
  @GenericGenerator(name = "custom-uuid", strategy = "xyz.sanjiaomao.user.infrastructure.db.IdentifierGenerator")
  private Long id;

  @Column
  private Long planId;

  @Column
  private Date cardDate;

  @Column
  private Date start;

  @Column
  private Date end;

  @Column
  private String remark;
}
