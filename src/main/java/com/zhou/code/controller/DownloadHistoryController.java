package com.zhou.code.controller;


import com.zhou.code.bean.BrowsingRecord;
import com.zhou.code.bean.DownloadHistory;
import com.zhou.code.bean.User;
import com.zhou.code.service.IBrowsingRecordService;
import com.zhou.code.service.IDownloadHistoryService;
import com.zhou.code.util.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhoulixin
 * @since 2022-04-25
 */
@RestController
@RequestMapping("/downloadHistory")
@CrossOrigin
public class DownloadHistoryController {
    @Autowired
    IDownloadHistoryService service;
    @RequestMapping("/all")
    @ApiOperation(value = "downloadHistory",httpMethod ="GET", notes = "返回当前用户所有下载信息")
    public Result all(HttpServletRequest request, HttpServletResponse response) {
        User cur_user = (User)request.getSession().getAttribute("cur_user");
        if(cur_user==null){
            return new Result().setCode(999).setData("请登录");
        }
        if(cur_user.getUserRole()==0){
            List<DownloadHistory> list = service.list();
            return Result.success(list);
        }else {
            List<DownloadHistory> list = service.getAllDownloadHistory(cur_user.getUserId());

            return Result.success(list);
        }
    }
}

