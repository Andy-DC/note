package com.demo;

import com.demo.common.redis.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisTests {
    @Autowired
    private RedisUtil redisUtil;

//     @Autowired
//    private StringRedisTemplate redisTemplate;


    /**
     * 操作类型
     */
    //StringRedisTemplate.opsForValue().* //操作String字符串类型
    //StringRedisTemplate.delete(key/collection) //根据key/keys删除
    //StringRedisTemplate.opsForList().*  //操作List类型
    //StringRedisTemplate.opsForHash().*  //操作Hash类型
    //StringRedisTemplate.opsForSet().*  //操作set类型
    //StringRedisTemplate.opsForZSet().*  //操作有序set


    /**
     * 常用操作
     */
//stringRedisTemplate.opsForValue().set("test", "100",60*10,TimeUnit.SECONDS);//向redis里存入数据和设置缓存时间
//
//stringRedisTemplate.boundValueOps("test").increment(-1);//val做-1操作
//
//stringRedisTemplate.opsForValue().get("test")//根据key获取缓存中的val
//
//stringRedisTemplate.boundValueOps("test").increment(1);//val +1
//
//stringRedisTemplate.getExpire("test")//根据key获取过期时间
//
//stringRedisTemplate.getExpire("test",TimeUnit.SECONDS)//根据key获取过期时间并换算成指定单位
//
//            stringRedisTemplate.delete("test");//根据key删除缓存
//
//stringRedisTemplate.hasKey("546545");//检查key是否存在，返回boolean值
//
//stringRedisTemplate.opsForSet().add("red_123", "1","2","3");//向指定key中存放set集合
//
//stringRedisTemplate.expire("red_123",1000 , TimeUnit.MILLISECONDS);//设置过期时间
//
//stringRedisTemplate.opsForSet().isMember("red_123", "1")//根据key查看集合中是否存在指定数据
//
//stringRedisTemplate.opsForSet().members("red_123");//根据key获取set集合


//    /**
//     * 测试字符串添加
//     */
//    @Test
//    public void setValue() {
//        String key = "key";
//        String test = "test";
//        redisTemplate.opsForValue().set(key, test);
//        System.out.println("测试字符串添加");
//    }
//
//
//    /**
//     * 测试字符串获取
//     */
//    @Test
//    public void getValue() {
//        String mykey = "mykey";
//        String v = redisTemplate.opsForValue().get(mykey);
//        System.out.println(v);
//        System.out.println("添加成功");
//
//    }
//
//    /**
//     * 测试list添加
//     */
//    @Test
//    public void setList() {
//        log.info("=========================redis List type insert ======================================");
//        String key = "setlistTest";
//        List<String> value = new ArrayList<>();
//        value.add("aaa");
//        value.add("bbb");
//        value.add("ccc");
//        redisTemplate.opsForList().rightPushAll(key, value);
//        log.info("=========================redis List type insert  END ======================================");
//    }
//
//    /**
//     * 测试list获取
//     */
//    @Test
//    public void getList() {
//        String key = "setlistTest";
//        redisTemplate.opsForList().range(key,1L,3L);
//
//    }
    @Test
    public void getListq() {
        String key = "key111";
        String test = "value";
       redisUtil.setEx(key, test,10l,TimeUnit.MINUTES);
            if (redisUtil.hasKey(key)==true){
                System.out.println("添加key成功："+key+"value值为"+test);
            }
        //redisUtil.delete(key);
    }

    @Test
    public void ccc() {
        //设置过期时间
        redisUtil.expire("key1",10l, TimeUnit.SECONDS);

    }


    @Test
    public void ccc1() {

    }


}
