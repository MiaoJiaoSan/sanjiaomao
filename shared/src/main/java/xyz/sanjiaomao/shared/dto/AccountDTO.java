package xyz.sanjiaomao.shared.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-01-01 23:19
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AccountDTO extends BaseDTO {

  private Long id;

  private String nickname;

  private String email;

  private String phone;
}

