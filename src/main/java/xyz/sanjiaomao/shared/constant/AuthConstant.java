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

  String TOKEN_SCRIPT_NO_REPEAT = "if redis.call('exists','KEYS[2]') == 0 then redis.call('setex', KEYS[1], 300, ARGV[1])   redis.call('setex',KEYS[2], 300, ARGV[2]) return 1 else return 0  end";

  String TOKEN_SCRIPT = "redis.call('setex', KEYS[1], 300, ARGV[1])  redis.call('setex',KEYS[2], 300, ARGV[2]) redis.call('expire', 'KEYS[2]', 1800 ) redis.call('del', KEYS[3]) return 1";

  String USER_ID = "user_id:";

  String TOKEN_CHECK = "if redis.call('exists',KEYS[1]) == 1 then local user = cjson.decode(redis.call('get', KEYS[1])) if redis.call('get','user_id:'..user.id) == KEYS[1] then return redis.call('get', KEYS[1])  end end";

}
