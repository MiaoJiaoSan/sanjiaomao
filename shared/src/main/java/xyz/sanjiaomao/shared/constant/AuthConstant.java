package xyz.sanjiaomao.shared.constant;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-01-01 23:51
 */
public interface AuthConstant {

  String AUTHORIZATION = "authorization";

  String TOKEN_PREFIX = "token:";

  String TOKEN_SCRIPT_NO_REPEAT = "if redis.call('exists','KEYS[2]') == 0 then redis.call('set', KEYS[1], ARGV[1]) redis.call('expire', 'KEYS[1]', 1800 )  redis.call('set',KEYS[2],ARGV[2]) redis.call('expire', 'KEYS[2]', 1800 ) return 1 else return 0  end";

  String TOKEN_SCRIPT = "redis.call('set', KEYS[1], ARGV[1]) redis.call('expire', 'KEYS[1]', 1800 )  redis.call('set',KEYS[2],ARGV[2]) redis.call('expire', 'KEYS[2]', 1800 ) return 1";

  String USER_ID = "user_id:";
}
