package com.commodityshareplatform.web.user.controller;

import com.commodityshareplatform.web.user.bean.User;
import com.commodityshareplatform.web.user.bean.UserExample;
import com.commodityshareplatform.web.user.server.IUserService;
import com.commodityshareplatform.web.utils.MD5Utils;
import com.commodityshareplatform.web.utils.Result;
import com.commodityshareplatform.web.utils.ResultUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    IUserService userService;

    /**
     * 跳转至用户列表页面
     */
    @RequestMapping("to_users")
    public String toUsersPage(){
        return "admin/user_list";
    }

    @RequestMapping(value = "to_user_select/{userId}",method = RequestMethod.GET)
    public ModelAndView toUserSelect(@PathVariable("userId") Integer userId){
        User user = userService.selectUserById(userId);

        ModelAndView mv = new ModelAndView("admin/user_select");
        mv.addObject("user",user);
        return mv;
    }

    /**
     * 按条件获取用户数据
     */
    @RequestMapping(value = "users",method = RequestMethod.GET)
    @ResponseBody
    public Result<User> getUsers(HttpServletRequest request){
        String userName = request.getParameter("userName") == null?"":request.getParameter("userName");
        String notUserId = request.getParameter("notUserId") == null?"":request.getParameter("notUserId");

        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        //查询条件
        if (!StringUtils.isEmpty(userName)){
            criteria.andUserNameEqualTo(userName);
        }
        if (!StringUtils.isEmpty(notUserId)){
            criteria.andUserIdNotEqualTo(Integer.parseInt(notUserId));
        }

        List<User> users = userService.selectUserByEx(example);

        //密码设为空
        for (User user:users){
            user.setUserPw("");
        }

        return ResultUtils.success(users);
    }

    /**
     * 全部用户数据（分页）
     */
    @RequestMapping(value = "userss",method = RequestMethod.GET)
    @ResponseBody
    public Result<PageInfo> getAllUsers(@RequestParam(value = "pn",defaultValue = "1")Integer pn){
        PageHelper.startPage(pn,5);
        List<User> users = userService.selectAllUser();

        //密码设为空
        for (User user:users){
            user.setUserPw("");
        }

        PageInfo pageInfo = new PageInfo(users,5);
        return ResultUtils.success(pageInfo);
    }

    @RequestMapping(value = "/user/{userId}",method = RequestMethod.GET)
    @ResponseBody
    public Result getUserById(@PathVariable("userId") Integer userId){
        User user = userService.selectUserById(userId);
        return ResultUtils.success(user);
    }

    /**
     * 添加用户
     */
    @RequestMapping(value = "user",method = RequestMethod.POST)
    @ResponseBody
    public Result addUser(User user){
        Integer result = userService.insertUser(user);
        if (result != null){
            return ResultUtils.success();
        }else{
            return ResultUtils.error(-1,"用户添加失败");
        }
    }

    @RequestMapping(value = "user",method = RequestMethod.PUT)
    @ResponseBody
    public Result saveUser(User user){
        Integer result = userService.updateUser(user);
        if (result != null){
            return ResultUtils.success();
        }else{
            return ResultUtils.error(-1,"用户保存失败");
        }
    }

    @RequestMapping(value = "user/{userId}",method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteUser(@PathVariable("userId") Integer userId){
        Integer result = userService.deleteUserById(userId);
        if (result != null){
            return ResultUtils.success();
        }else{
            return ResultUtils.error(-1,"用户保存失败");
        }
    }

    @RequestMapping(value = "password",method = RequestMethod.POST)
    @ResponseBody
    public Result saveUserPassword(User user){
        Object parsePwd = MD5Utils.stringToMD5(user.getUserPw());
        user.setUserPw(parsePwd.toString());
        Integer result = userService.updateUser(user);
        if (result != null){
            return ResultUtils.success();
        }else{
            return ResultUtils.error(-1,"用户保存失败");
        }
    }
}
