package xyz.sanjiaomao.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/auth")
public class SecurityController {

    @GetMapping
    public Principal getUser(Principal principal) {
        return principal;
    }
}
