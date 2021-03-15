package cn.seeyourface.redis02springboot.entity;

/**
 * @Auther: yanglei
 * @Date: 2021/3/15 21:10
 * @Version: V1.0
 * @Description: TODO
 */
public class User {
    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
