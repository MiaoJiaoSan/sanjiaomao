package xyz.sanjiaomao.user.domain.user.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2020-12-27 23:22
 */
@Data
@Entity(name = "user_act_rel")
public class UserActRel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "user_id", nullable = false)
  private Long userId;
  @Column(name = "act_id", nullable = false)
  private Long actId;
}
