package xyz.sanjiaomao.user.interfaces.facade;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import xyz.sanjiaomao.user.application.cmd.opt.ModifyUserCmd;
import xyz.sanjiaomao.user.application.cmd.opt.SaveUserCmd;
import xyz.sanjiaomao.user.application.service.UserOptService;

@RequestMapping("/user")
@RestController
@Slf4j
public class UserOptController {

  @Autowired
  private UserOptService userOptService;

  @PostMapping
  public Boolean save(@RequestBody @Validated SaveUserCmd cmd) {
    userOptService.save(cmd);
    return true;
  }

  @PutMapping
  public Boolean modify(@RequestBody @Validated ModifyUserCmd cmd) {
    userOptService.modify(cmd);
    return true;
  }
}
