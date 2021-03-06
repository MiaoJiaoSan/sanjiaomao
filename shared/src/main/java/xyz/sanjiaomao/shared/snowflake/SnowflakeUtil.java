package xyz.sanjiaomao.shared.snowflake;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

public enum SnowflakeUtil {

  /**
   * 账号
   */
  ACCOUNT(IdUtil.getSnowflake(Integer.parseInt(System.getProperty("workId")), 1)),
  /**
   * 用户
   */
  USER(IdUtil.getSnowflake(Integer.parseInt(System.getProperty("workId")), 2)),
  /**
   * 角色
   */
  ROLE(IdUtil.getSnowflake(Integer.parseInt(System.getProperty("workId")), 3)),
  /**
   * 资源
   */
  RESOURCE(IdUtil.getSnowflake(Integer.parseInt(System.getProperty("workId")), 4));

  private Snowflake snowflake;

  SnowflakeUtil(Snowflake snowflake) {
    this.snowflake = snowflake;
  }

  public long nextId() {
    return snowflake.nextId();
  }

}
