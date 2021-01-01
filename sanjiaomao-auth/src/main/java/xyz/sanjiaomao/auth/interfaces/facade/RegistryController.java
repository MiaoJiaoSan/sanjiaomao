package xyz.sanjiaomao.auth.interfaces.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-01-01 23:15
 */
@RestController
@RequestMapping("/registry")
public class RegistryController {

  @Autowired
  private RestTemplate restTemplate;


  @PostMapping
  public Boolean registry(){
    return true;
  }
}
