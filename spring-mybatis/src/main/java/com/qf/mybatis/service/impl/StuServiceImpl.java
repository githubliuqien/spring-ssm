package com.qf.mybatis.service.impl;

import com.qf.mybatis.mapper.StuMapper;
import com.qf.mybatis.model.Stu;
import com.qf.mybatis.service.StuService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class StuServiceImpl implements StuService {

    @Resource
    StuMapper stuMapper;

    public int insert(Stu stu) {
        int insert = stuMapper.insert(stu);
        System.out.println("添加的stu sid为:"+stu.getSid());
        return insert;
    }
}
