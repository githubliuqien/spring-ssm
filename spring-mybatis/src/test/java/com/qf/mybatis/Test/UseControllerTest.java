package com.qf.mybatis.Test;

import com.qf.mybatis.mapper.StuMapper;
import com.qf.mybatis.model.Stu;
import com.qf.mybatis.service.StuService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-config.xml","classpath:spring-mybatis.xml"})
public class UseControllerTest {
    @Resource
    StuMapper stuMapper;

    /**
     * 插入数据
     */
    @Test
    public void  insert(){
        stuMapper.insert(Stu.builder().gender("女").age(23).sName("朱颜辞镜花辞树").build());
    }


    /**
     * 多条件查询
     */
    @Test
    public void queryMultiple(){
        List<Stu> stuList = stuMapper.queryMultiple(Stu.builder().gender("女").build());
        stuList.forEach(s-> System.out.println(s.toString()));
    }

    /**
     * 根据id批量删除
     */
    @Test
    public void deleteBatch(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list,1,7,30);
        System.out.println(stuMapper.deleteBatch(list));
    }


    /**
     * 根据用户sid 修改内容
     */
    @Test
    public  void  updateBySid(){
        System.out.println(stuMapper.update(Stu.builder().sid(2).sName("彭如妍").build()));
    }


}