package xyz.sanjiaomao.user.interfaces.facade;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.sanjiaomao.user.application.cmd.opt.SaveUserCmd;
import xyz.sanjiaomao.user.application.service.UserOptService;
import xyz.sanjiaomao.user.interfaces.assembler.UserAssembler;
import xyz.sanjiaomao.user.interfaces.dto.UserDTO;

@RequestMapping("/user")
@RestController
@Slf4j
public class UserOptController {

  @Autowired
  private UserOptService userOptService;
  @Autowired
  private UserAssembler userAssembler;

  public Boolean save(UserDTO dto){
    SaveUserCmd cmd = userAssembler.convert(dto);
    userOptService.save(cmd);
    return true;
  }
}
