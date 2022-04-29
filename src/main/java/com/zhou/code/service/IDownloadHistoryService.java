package com.zhou.code.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.code.bean.BrowsingRecord;
import com.zhou.code.bean.DownloadHistory;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhoulixin
 * @since 2022-04-25
 */
public interface IDownloadHistoryService extends IService<DownloadHistory> {

    List<DownloadHistory> getAllDownloadHistory(int userId);
}
