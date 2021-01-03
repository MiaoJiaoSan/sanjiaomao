package xyz.sanjiaomao.shared.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-01-03 18:29
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ResultDTO<T> extends BaseDTO {

  private T result;

  private ResultDTO(){

  }

  public ResultDTO(T result){
    this.result = result;
  }

}
