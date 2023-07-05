package com.qf.relevancy.mapper;

import com.qf.relevancy.model.po.User;
import com.qf.relevancy.service.impl.UserServerImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-config.xml","classpath:spring-mybatis.xml"})
public class UserMapperTest {

    @Resource
    UserMapper userMapper;

    @Resource
    PowerMapper powerMapper;

    @Resource
    RoleMapper roleMapper;

    @Test
    public void  testRole(){
        userMapper.selectByRoleID(9);
    }

    @Test
    public void selectBatch(){
        userMapper.selectBean(User.builder().uAge(18).uPassword("123").build());
    }

    @Test
    public void selectByiId(){
        System.out.println(userMapper.selectByID(4));
    }

    @Test
    public void selectByPower(){
        powerMapper.selectListByRoleId(1);
    }

    /**
     * 根据角色 id 查询当前角色信息(包含权限)
     * @param id
     * @return
     */
    @Test
    public void selectByRole(){
        roleMapper.selectBeanRoleId(1);
    }


    /**
     * 根据用户ID 查询出 用户角色  用户权限 信息
     * 返回值类型:  UserBoTo
     *                包含: User 的详细属性 和 RoleBo
     *                RoleBo 为 UserBoTo  的属性  它包含(封装) 用户的角色信息 和 权限信息
     * 查询的流程:
     * 1. userMapper 调用 selectByIdToAllInfo 方法 查询
     *
     * 2.在 selectByIdToAllInfo 的 resultMap 映射结果集中  使用 联接查询 给UserBoTo 赋值
     *
     *
     *
     *
      */
    @Test
    public void  selectAllInfo(){
        System.out.println(userMapper.selectByIdToAllInfo(1));
    }


    @Resource
    UserServerImpl userServer;


    @Test
    public void   User(){
        userMapper.selectByIdToAllInfo(1);
        userMapper.selectByIdToAllInfo(1);
        userMapper.selectByIdToAllInfo(1);
        userMapper.selectByIdToAllInfo(1);
    }
}