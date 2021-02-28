package xyz.sanjiaomao.shared.cmd;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-02-28 00:57
 */
@Data
public class ModifyCardCmd implements AccountId {

  @NotNull(message = "账号不能为空")
  private Long accountId;

  @NotNull(message = "备注不能为空")
  private String remark;
}
