package xyz.sanjiaomao.user.application.cmd.opt;

import lombok.Data;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-01-01 20:05
 */
@Data
public class AddResourceCmd {

  private Long roleId;

  private Long resourceId;

  private Integer privilege;

}
