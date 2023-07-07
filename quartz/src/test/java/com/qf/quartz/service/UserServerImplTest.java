package com.qf.quartz.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-quartz.xml")
public class UserServerImplTest {

    @Autowired
    UserServer userServer;


    @Test
    public void test(){
        userServer.submitTask();
    }
}
