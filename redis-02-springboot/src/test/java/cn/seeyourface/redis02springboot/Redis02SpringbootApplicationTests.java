package cn.seeyourface.redis02springboot;

import cn.seeyourface.redis02springboot.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class Redis02SpringbootApplicationTests {

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        //操作不同的数据类型，api和我们的指令是一样的
        //opsForValue  操作字符串，类似string
        //opsForList  操作list
        //opsForSet  操作集合
        //opsForHash  操作hash
        //opsForZSet  操作有序集合
        //opsForGeo  操作地图
        //opsForHyperLogLog

        //除了基本的操作，我们常用的方法都可以通过redisTemplate来操作。例如事务和基本的crud

        //获取连接对象
        /*RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
        connection.flushAll();
        connection.flushDb();*/
        User user = new User("yanglei", 3);

        redisTemplate.opsForValue().set("user", user);
        System.out.println(redisTemplate.opsForValue().get("user"));

    }

}
