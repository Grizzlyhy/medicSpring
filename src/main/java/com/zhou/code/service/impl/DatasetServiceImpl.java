package com.zhou.code.service.impl;

import com.zhou.code.bean.Dataset;
import com.zhou.code.mapper.DatasetMapper;
import com.zhou.code.service.IDatasetService;
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
public class DatasetServiceImpl extends ServiceImpl<DatasetMapper, Dataset> implements IDatasetService {

    @Autowired
    DatasetMapper datasetMapper;
    @Override
    public Integer getLastId() {
        return datasetMapper.getLastId();
    }

    @Override
    public List<Dataset> getDatasetByUserId(Integer userId) {
        return datasetMapper.getDatasetByUserId(userId);
    }
}
