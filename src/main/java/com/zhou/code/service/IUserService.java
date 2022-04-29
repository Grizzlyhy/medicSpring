package com.zhou.code.service;

import com.zhou.code.bean.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhoulixin
 * @since 2022-03-04
 */
public interface IUserService extends IService<User> {
   public List<User> getUserByAccount(String account);
}
