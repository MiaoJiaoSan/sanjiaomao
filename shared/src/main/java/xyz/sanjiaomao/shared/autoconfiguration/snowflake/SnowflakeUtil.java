package xyz.sanjiaomao.shared.autoconfiguration.snowflake;

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
   * 账号用户关系
   */
  USER_ACT_REL(IdUtil.getSnowflake(Integer.parseInt(System.getProperty("workId")), 3))
  ;



  private Snowflake snowflake;

  SnowflakeUtil(Snowflake snowflake){
    this.snowflake = snowflake;
  }

  public long nextId(){
    return snowflake.nextId();
  }

}
