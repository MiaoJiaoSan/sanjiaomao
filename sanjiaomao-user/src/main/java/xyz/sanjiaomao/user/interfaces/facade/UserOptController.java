package xyz.sanjiaomao.user.interfaces.facade;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
@Slf4j
public class UserOptController {


  @GetMapping
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public String info() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    return String.valueOf(authentication.getPrincipal());
  }

}
