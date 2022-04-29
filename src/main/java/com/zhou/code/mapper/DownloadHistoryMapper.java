package com.zhou.code.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhou.code.bean.BrowsingRecord;
import com.zhou.code.bean.DownloadHistory;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhoulixin
 * @since 2022-04-25
 */
public interface DownloadHistoryMapper extends BaseMapper<DownloadHistory> {
    List<DownloadHistory> getAllDownloadHistory(int userId);
}
