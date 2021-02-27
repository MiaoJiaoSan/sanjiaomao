package xyz.sanjiaomao.user.interfaces.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import xyz.sanjiaomao.annotation.Auth;
import xyz.sanjiaomao.shared.cmd.AddUserCmd;
import xyz.sanjiaomao.shared.dto.ResultDTO;
import xyz.sanjiaomao.user.application.UserCmdService;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-02-27 16:15
 */
@RequestMapping("/user")
@RestController
public class UserFacade {

  @Autowired
  UserCmdService userCmdService;

  @Auth
  @PostMapping
  public ResultDTO addUser(@Validated @RequestBody AddUserCmd cmd){
    userCmdService.addUser(cmd);
    return new ResultDTO(true);
  }

}
