package com.zhou.code.mapper;

import com.zhou.code.bean.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhou.code.cache.MybatisRedisCache;
import org.apache.ibatis.annotations.CacheNamespace;
import java.util.*;
/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhoulixin
 * @since 2022-03-04
 */
@CacheNamespace(implementation= MybatisRedisCache.class,eviction=MybatisRedisCache.class)
public interface UserMapper extends BaseMapper<User> {
    List<User> getUserByAccount(String user_account);
}
