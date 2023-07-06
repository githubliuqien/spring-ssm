package com.qf.logback.test;

import com.qf.logback.model.User;
import com.qf.logback.service.UserServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class Text {

    @Resource
    UserServer userServer;

    @Test
    public void add(){
        for (int i = 0; i < 30000; i++) {
            userServer.addUser(User.builder().userName("_aa").userPassWord("523").checkPassWord("523").build());
        }
    }

}
