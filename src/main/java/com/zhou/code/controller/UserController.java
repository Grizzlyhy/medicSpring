package com.zhou.code.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhou.code.bean.User;
import com.zhou.code.bean.vo.LoginVo;
import com.zhou.code.error.AddException;
import com.zhou.code.error.UpdateException;
import com.zhou.code.service.IUserService;
import com.zhou.code.util.MD5;
import com.zhou.code.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
@RequestMapping("/user")
@CrossOrigin
@Api(protocols = "http,https", produces = "application/json", tags = "user")
public class UserController {
    @Autowired
    IUserService userService;
    @RequestMapping("/all")
    @ApiOperation(value = "user",httpMethod ="GET", notes = "返回所有用户信息")
    public Result all(HttpServletRequest request) {
        User cur_user = (User)request.getSession().getAttribute("cur_user");
        if(cur_user==null){
            return new Result().setCode(999).setData("请登录");
        }
        if(cur_user.getUserRole()!=0){
            return new Result().setCode(999).setData("没有权限");
        }
        List<User> list = userService.list();
        return Result.success(list);
    }
    @PostMapping("/one")
    @ApiOperation(value = "user", notes = "添加用户信息")
    public Result addone(HttpServletRequest request,@RequestBody User user) {
        User cur_user = (User)request.getSession().getAttribute("cur_user");
        if(cur_user==null){
            return new Result().setCode(999).setData("请登录");
        }
        if(cur_user.getUserRole()!=0){
            return new Result().setCode(999).setData("没有权限");
        }
        user.setUserDepartment("无");
        user.setDeleted(false);
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        boolean save = userService.save(user);
        if(save){
            return Result.success("添加成功！");
        } else{
            throw new AddException("添加用户失败");
        }
    }
    @PutMapping("/one")
    @ApiOperation(value = "user", notes = "添加用户信息")
    public Result updateone(HttpServletRequest request,@RequestBody User user) throws UpdateException {
        User cur_user = (User)request.getSession().getAttribute("cur_user");
        if(cur_user==null){
            return new Result().setCode(999).setData("请登录");
        }
        if(cur_user.getUserRole()!=0){
            return new Result().setCode(999).setData("没有权限");
        }
        boolean b = userService.updateById(user);
        if(b){
            return Result.success("更新成功!");
        }
        else{
            throw new UpdateException("更新失败！");
        }
    }
    @DeleteMapping(value="/one")
    public Result delete(HttpServletRequest request,@PathVariable("userId") Integer userId){
        User user = userService.getById(userId);
        user.setDeleted(true);
        boolean b = userService.updateById(user);
        if(b){
            return new Result().setCode(200).setData("删除成功");
        }else{
            return new Result().setCode(999).setData("删除失败");
        }

    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(HttpServletRequest request,@RequestBody LoginVo loginVo){
        List<User> users= userService.getUserByAccount(loginVo.getAccount());
        if(request.getSession().getAttribute("cur_user")!=null){
            return new Result().setCode(999).setData("您已登录");
        }
        //String pwd = MD5.md5(loginVo.getPassword());
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getUserPwd().equals(loginVo.getPassword())&&!users.get(i).getDeleted()){
                request.getSession().setMaxInactiveInterval(24*60*60);    //24小时
                request.getSession().setAttribute("cur_user",users.get(i));
                System.out.println("登录成功");
                return new Result().setCode(200).setData("登录成功");
            }
        }
        return new Result().setCode(999).setData("登录失败");

    }
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public Result logout(HttpServletRequest request){
        request.getSession().invalidate();
        return new Result().setCode(200).setData("登出成功");
    }

}

