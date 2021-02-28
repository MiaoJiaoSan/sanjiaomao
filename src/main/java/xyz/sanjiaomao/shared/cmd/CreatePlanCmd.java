package xyz.sanjiaomao.shared.cmd;

import lombok.Data;

import java.util.Date;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-02-28 01:40
 */
@Data
public class CreatePlanCmd implements AccountId {

  private Long accountId;

  private String planName;

  private String content;

  private Date end;

  private String remark;
}
