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
 * create by 2021-02-28 03:00
 */
@Data
@Entity(name = "plan")
public class PlanDO {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "custom-uuid")
  @GenericGenerator(name = "custom-uuid", strategy = "xyz.sanjiaomao.user.infrastructure.db.IdentifierGenerator")
  private Long id;

  @Column
  private Long accountId;

  @Column
  private String planName;

  @Column
  private String content;

  @Column
  private Date start;

  @Column
  private Date end;

  @Column
  private String finished;
}
