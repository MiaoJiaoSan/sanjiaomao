package xyz.sanjiaomao.shared.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import xyz.sanjiaomao.shared.dto.ResultDTO;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-02-27 15:41
 */
@RestControllerAdvice
public class Handler {


  @ExceptionHandler(value = IllegalArgumentException.class)
  public ResultDTO illegalArgumentException(IllegalArgumentException e){
    return new ResultDTO(e.getMessage(),false);
  }

}
