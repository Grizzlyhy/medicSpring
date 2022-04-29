package com.zhou.code.mapper;

import com.zhou.code.bean.Algorithm;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhou.code.bean.Dataset;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhoulixin
 * @since 2022-03-04
 */
public interface AlgorithmMapper extends BaseMapper<Algorithm> {

    List<Algorithm> getAlgorithmByUserId(Integer userId);

    Integer getLastId();
}
