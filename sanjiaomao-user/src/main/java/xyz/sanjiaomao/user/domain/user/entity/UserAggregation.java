package xyz.sanjiaomao.user.domain.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2020-12-29 12:57
 */
@Data
@AllArgsConstructor
public class UserAggregation {

  private Account account;

  private User user;

}
