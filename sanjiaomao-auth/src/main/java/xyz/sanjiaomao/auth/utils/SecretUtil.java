package xyz.sanjiaomao.auth.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SecretUtil {

  public static void main(String[] args) {
    String miaojiaosan ="{bcrypt}"+ new BCryptPasswordEncoder().encode("123456");
    System.out.println(miaojiaosan);
  }
}
