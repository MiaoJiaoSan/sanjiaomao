package xyz.sanjiaomao.shared.cmd;

import lombok.Data;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-02-27 16:50
 */
@Data
public class AddUserCmd implements AccountId {

  private Long accountId;

  private String name;

  private Integer age;

  private String gender;

  private String idCard;

  private String mobile;

  private String email;
}
