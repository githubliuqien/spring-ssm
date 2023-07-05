package com.qf.relevancy.service.impl;

import com.qf.relevancy.mapper.UserMapper;
import com.qf.relevancy.service.UserServer;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Data
@Service
public class UserServerImpl  implements UserServer {

    @Resource
    UserMapper userMapper;

    /**
     * @Transactional(readOnly = true)
     *    开启一级缓存
     */
//    @Transactional(readOnly = true)
    public void  selectByIdToAllInfo(int num){
        userMapper.selectByIdToAllInfo(num);
    }
}
