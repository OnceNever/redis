package cn.seeyourface.testPing;

import redis.clients.jedis.Jedis;

public class TestPing {
    public static void main(String[] args) {
        //1.new Jedis对象即可
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        //jedis 所有命令就是之前学过的命令

        System.out.println(jedis.ping());
    }
}
