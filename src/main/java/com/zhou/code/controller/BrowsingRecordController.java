package com.zhou.code.controller;


import com.zhou.code.bean.BrowsingRecord;
import com.zhou.code.bean.CaseImage;
import com.zhou.code.bean.User;
import com.zhou.code.error.AddException;
import com.zhou.code.service.ICaseImageService;
import com.zhou.code.util.Result;
import com.zhou.code.service.IBrowsingRecordService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
@RequestMapping("/browsingRecord")
@CrossOrigin
public class BrowsingRecordController {
    @Autowired
    IBrowsingRecordService service;
    @RequestMapping("/all")
    @ApiOperation(value = "browsingRecord", httpMethod ="GET",notes = "返回所有浏览记录")
    public Result all(HttpServletRequest request) {
        User cur_user = (User)request.getSession().getAttribute("cur_user");
        if(cur_user==null){
            return new Result().setCode(999).setData("请登录");
        }
        if(cur_user.getUserRole()!=0){
            return new Result().setCode(999).setData("没有权限");
        }
        List<BrowsingRecord> list = service.list();
        System.out.println(list);
        return Result.success(list);
    }

}

