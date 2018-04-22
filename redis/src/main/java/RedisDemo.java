import redis.clients.jedis.Jedis;

/**
 * Created by WS on 2018/4/22.
 */
public class RedisDemo {
    public static void main(String[] args) {
        // 连接本地的 Redis 服务
        Jedis jedis = new Jedis("192.168.109.128",6379);
        System.out.println("连接本地的 Redis 服务成功！");
        // 查看服务是否运行
        System.out.println("服务 正在运行: " + jedis.ping());
    }
}
