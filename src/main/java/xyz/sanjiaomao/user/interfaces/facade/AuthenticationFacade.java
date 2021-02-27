package xyz.sanjiaomao.user.interfaces.facade;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.sanjiaomao.shared.dto.ResultDTO;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-02-27 21:45
 */
@RequestMapping("/public/authentication")
@RestController
public class AuthenticationFacade {

  @RequestMapping
  public ResultDTO authentication() {
    return new ResultDTO("未登陆", false);
  }

}
