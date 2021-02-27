package xyz.sanjiaomao.user.infrastructure.db;

import cn.hutool.core.util.ReflectUtil;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;

import java.io.Serializable;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-02-27 15:15
 */
public class IdentifierGenerator implements org.hibernate.id.IdentifierGenerator {
  @Override
  public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
    return ReflectUtil.invoke(o, "getId");
  }
}
