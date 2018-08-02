package com.example.demo720;

import com.example.demo720.biz.serviceimpl.UserServiceImpl;
import com.example.demo720.domain.entity.User;
import com.example.demo720.domain.dao.UserMapper;
import com.example.demo720.utils.quicksort;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo720ApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void sayHello() throws Exception {
        // 模拟 get 请求
        mockMvc.perform(
                get("/hello") // get 请求 url /hello
                        .param("name", "tom") // 参数 name=tom
                        .contentType(MediaType.APPLICATION_JSON_UTF8)) // 设置请求头 Content-Type = application/json;charset=UTF-8
                .andExpect(status().isOk()) // 期望返回的状态码为200
                .andExpect(content().string("hello tom")); // 期望返回值为"hello tom"
    }

    @Test
    public void setRedis()throws Exception{
        redisTemplate.opsForValue().set("key1","value1");
        Assert.assertEquals("value1",redisTemplate.opsForValue().get("key1"));
    }

    @Test
    public void findUserNameByPhoneWithServiceImpl() throws Exception {
        String name=userServiceImpl.getUsernameByPhone("1");
        Assert.assertEquals("1",name);
    }

    @Test
    public void findUserNameByPhoneWithMapper() throws Exception {
        String name=userMapper.getUsernameByPhone("1");
        Assert.assertEquals("1",name);
    }

    @Test
    public void findUserByPhone() throws Exception {
        User user=userMapper.findUserByPhone("1");
        User userExpected=new User(1001, "1","1","1");
        Assert.assertEquals("1",user.getName());
    }

    @Test
    public void test() throws Exception {
        userMapper.insert("winterchen", "123456", "1");
        User u = userMapper.findUserByPhone("1");
        Assert.assertEquals("winterchen", u.getName());
    }

    @Test
    public void test2(){
        int  arr []=new int []{48,39,11,100,32,22,9,1,88,45,12,98};
        quicksort.runquicksort(arr);
        Assert.assertEquals(1,arr[0]);
    }

    @Test
    public void test3(){
        int  arr []=new int []{48,39,11,100,32,22,9,1,88,45,12,98};
        quicksort.runquicksort(arr);
        Assert.assertEquals(11,arr[2]);
    }

    @Test
    public void test4(){
        int  arr []=new int []{48,39,11,100,32,22,9,1,88,45,12,98};
        quicksort.runquicksort(arr);
        Assert.assertEquals(11,arr[1]);
    }
}
