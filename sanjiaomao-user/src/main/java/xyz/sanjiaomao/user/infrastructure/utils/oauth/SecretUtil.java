package xyz.sanjiaomao.user.infrastructure.utils.oauth;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SecretUtil {

  public static void main(String[] args) {
    String miaojiaosan ="{bcrypt}"+ new BCryptPasswordEncoder().encode("1");
    System.out.println(miaojiaosan);
  }
}
