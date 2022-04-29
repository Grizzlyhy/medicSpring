package com.zhou.code.mapper;

import com.zhou.code.bean.Dataset;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhoulixin
 * @since 2022-03-04
 */
public interface DatasetMapper extends BaseMapper<Dataset> {

    Integer getLastId();
    List<Dataset>  getDatasetByUserId(Integer userId);
}
