package cn.seeyourface.testAffairs;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class TestAffairs {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        jedis.flushDB();

        JSONObject json = new JSONObject();
        json.put("hello", "world");
        json.put("name", "yanglei");
        String s = JSONObject.toJSONString(json);

        //开启事务
        Transaction multi = jedis.multi();
        try {
            multi.set("object1", s);
            multi.set("object2", s);
            //抛出一个异常
            int i = 1/0;
            //执行事务
            multi.exec();
        } catch (Exception e) {
            //出现异常取消事务
            multi.discard();
            e.printStackTrace();
        } finally {
            System.out.println(jedis.get("object1"));
            System.out.println(jedis.get("object2"));
            //关闭连接
            jedis.close();
        }


    }
}
