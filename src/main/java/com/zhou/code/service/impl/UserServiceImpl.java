package com.zhou.code.service.impl;

import com.zhou.code.bean.User;
import com.zhou.code.mapper.UserMapper;
import com.zhou.code.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhoulixin
 * @since 2022-03-04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    UserMapper userMapper;
    @Override
  public   List<User> getUserByAccount(String account){
        List<User> userByAccount = userMapper.getUserByAccount(account);
        return userByAccount;
    }

}
