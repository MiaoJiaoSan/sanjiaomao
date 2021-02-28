package xyz.sanjiaomao.shared.cmd;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-02-28 01:06
 */
@Data
public class PlanEventCmd implements AccountId {

  @NotNull(message = "账号id不能为空")
  private Long accountId;

  @NotNull(message = "备注不能为空")
  private String remark;

}
