package com.zhou.code.service.impl;

import com.zhou.code.bean.Algorithm;
import com.zhou.code.bean.Dataset;
import com.zhou.code.mapper.AlgorithmMapper;
import com.zhou.code.service.IAlgorithmService;
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
public class AlgorithmServiceImpl extends ServiceImpl<AlgorithmMapper, Algorithm> implements IAlgorithmService {
@Autowired
AlgorithmMapper algorithmMapper;
    @Override
    public List<Algorithm> getAlgorithmByUserId(Integer userId) {
        return algorithmMapper.getAlgorithmByUserId(userId);
    }

    @Override
    public Integer getLastId() {
        return algorithmMapper.getLastId();
    }
}
