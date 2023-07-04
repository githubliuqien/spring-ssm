package com.qf.mybatis.controller;

import com.qf.mybatis.model.Stu;
import com.qf.mybatis.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UseController {

    @Resource
    StuService stuService;

    @GetMapping("insert")
    public void insert() {
        stuService.insert(Stu.builder().gender("男").age(33).sName("李四").build());
    }

}
