package xyz.sanjiaomao.user.application.cmd.opt;

import lombok.Data;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-01-01 21:03
 */
@Data
public class ModifyPrivilegeCmd {

  private Long roleId;

  private Long resourceId;

  private Integer privilege;
}
