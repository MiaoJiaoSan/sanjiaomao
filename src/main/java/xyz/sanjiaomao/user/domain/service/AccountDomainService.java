package xyz.sanjiaomao.user.domain.service;


import cn.hutool.crypto.digest.MD5;
import org.springframework.stereotype.Service;

@Service
public class AccountDomainService {

  public String encryption(String source) {
    MD5 md5 = MD5.create();
    return md5.digestHex(source);
  }
}
