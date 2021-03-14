package cn.seeyourface.testKey;

import redis.clients.jedis.Jedis;

public class TestKeys {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        System.out.println("清空当前数据库的数据："+jedis.flushDB());
        System.out.println("判断某个键是否存在："+jedis.exists("username"));
        System.out.println("新增<'username', 'yanglei'>的键值对"+jedis.set("username", "yanglei"));
        System.out.println("新增<'password', 'password'>的键值对"+jedis.set("password", "password"));
        System.out.println("系统中所有的键如下："+jedis.keys("*"));
        System.out.println("删除键password："+jedis.del("password"));
        System.out.println("判断键password是否存在："+jedis.exists("password"));
        System.out.println("查看username所存储的值对应的数据类型："+jedis.type("username"));
        System.out.println("随机返回key空间的一个："+jedis.randomKey());
        System.out.println("重命名key："+jedis.rename("username", "name"));
        System.out.println("取出改后的name："+jedis.get("name"));
        System.out.println("返回当前数据库中key的数目："+jedis.dbSize());
        System.out.println("清空所有数据库中的数据："+jedis.flushAll());
    }
}
