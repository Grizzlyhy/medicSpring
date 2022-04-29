package com.zhou.code.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.code.bean.BrowsingRecord;
import com.zhou.code.bean.DownloadHistory;
import com.zhou.code.mapper.DownloadHistoryMapper;
import com.zhou.code.service.IDownloadHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhoulixin
 * @since 2022-04-25
 */
@Service
public class DownloadHistoryServiceImpl extends ServiceImpl<DownloadHistoryMapper, DownloadHistory> implements IDownloadHistoryService {
    @Autowired
    DownloadHistoryMapper downloadHistoryMapper;
    @Override
    public List<DownloadHistory> getAllDownloadHistory(int userId) {
        return downloadHistoryMapper.getAllDownloadHistory(userId);
    }
}
