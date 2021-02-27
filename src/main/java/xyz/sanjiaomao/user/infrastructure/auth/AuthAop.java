package xyz.sanjiaomao.user.infrastructure.auth;

import cn.hutool.core.lang.Assert;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import xyz.sanjiaomao.shared.cmd.AccountId;
import xyz.sanjiaomao.shared.constant.AuthConstant;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-02-27 18:12
 */
@Aspect
@Component
public class AuthAop {


  @Pointcut("@annotation(xyz.sanjiaomao.shared.annotation.Auth)")
  public void joinPoint() {
  }


  @Before("joinPoint()")
  public void before(JoinPoint point) {
    Object[] args = point.getArgs();
    Optional<Long> optional = Arrays.stream(args).filter(o -> o instanceof AccountId).map(o -> (AccountId) o).map(AccountId::getAccountId).findFirst();
    Assert.isTrue(optional.isPresent(), "未登录");
    Long accountId = optional.get();
    Assert.isTrue(Objects.equals(accountId, AuthConstant.ACCOUNT_ID.get()), "未登录");

  }
}
