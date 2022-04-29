package com.zhou.code.service;

import com.zhou.code.bean.Algorithm;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.code.bean.Dataset;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhoulixin
 * @since 2022-03-04
 */
public interface IAlgorithmService extends IService<Algorithm> {

    List<Algorithm> getAlgorithmByUserId(Integer userId);

    Integer getLastId();
}
