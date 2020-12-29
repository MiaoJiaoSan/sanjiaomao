package xyz.sanjiaomao.user.domain.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2020-12-27 23:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserActRel {
  private Long id;
  private Long userId;
  private Long actId;
}
