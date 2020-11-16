package xyz.sanjiaomao.user.interfaces.facade;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserOptController {


  @GetMapping
  public String info(){
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    return String.valueOf(authentication.getPrincipal());
  }

}
