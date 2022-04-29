package com.zhou.code.controller;


import com.zhou.code.bean.CaseImage;
import com.zhou.code.bean.Dataset;
import com.zhou.code.bean.User;
import com.zhou.code.error.AddException;
import com.zhou.code.service.ICaseImageService;
import com.zhou.code.service.IDatasetService;
import com.zhou.code.util.Result;
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
 * @since 2022-03-04
 */
@RestController
@RequestMapping("/caseImage")
@CrossOrigin
public class CaseImageController {
    @Autowired
    ICaseImageService caseImageService;
    @RequestMapping("/all")
    @ApiOperation(value = "caseImage",httpMethod ="GET", notes = "返回所有案例信息")
    public Result all(HttpServletRequest request) {
        List<CaseImage> list = caseImageService.list();
        User cur_user = (User)request.getSession().getAttribute("cur_user");
        if(cur_user==null){
            return new Result().setCode(999).setData("请登录");
        }
        if(cur_user.getUserRole()!=0){
            return new Result().setCode(999).setData("没有权限");
        }
        return Result.success(list);
    }
    @PostMapping("/one")
    @ApiOperation(value = "caseImage", notes = "添加案例信息")
    public Result one(@RequestBody CaseImage caseImage) {
        boolean save = caseImageService.save(caseImage);
        if(save){
            return Result.success("添加成功！");
        } else{
            throw new AddException("添加失败");
        }
    }
}

