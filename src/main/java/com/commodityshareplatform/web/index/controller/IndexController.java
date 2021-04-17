package com.commodityshareplatform.web.index.controller;

import com.commodityshareplatform.web.user.bean.User;
import com.commodityshareplatform.web.user.server.IUserService;
import com.commodityshareplatform.web.user.server.impl.UserService;
import com.commodityshareplatform.web.utils.MD5Utils;
import com.commodityshareplatform.web.utils.Result;
import com.commodityshareplatform.web.utils.ResultUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class IndexController {
    @Autowired
    IUserService userService;


    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String index(){
        return "commodityWeb/index";
    }

    @RequestMapping(value = "to_login",method = RequestMethod.GET)
    public String to_login(){
        return "commodityWeb/login";
    }

    @RequestMapping(value = "to_register",method = RequestMethod.GET)
    public String to_register(){
        return "commodityWeb/register";
    }

    @RequestMapping(value = "to_showpage",method = RequestMethod.GET)
    public String to_showpage(Map<String,Object> map, HttpServletRequest request){
        String commodityTag = request.getParameter("commodityTag") == null?"":request.getParameter("commodityTag");
        map.put("commodityTag",commodityTag);
        return "commodityWeb/showpage";
    }

    @RequestMapping(value = "to_commoditypage",method = RequestMethod.GET)
    public String to_commoditypage(@RequestParam(value = "commodityId") Integer commodityId,Map<String,Object> map){
        map.put("commodityId",commodityId);
        return "commodityWeb/commodityPage";
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    @ResponseBody
    public Result login(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("rememberMe") Boolean rememberMe , HttpSession session){
        Subject subject = SecurityUtils.getSubject();

        //判断是否有有效凭据来证明了自己的身份,如果没有则进行登录认证
        if(!subject.isAuthenticated()){
            //1、获取提交的用户名以及密码封装为UsernamePasswordToken
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,password);
            //判断前端是否勾选记住我
            //通过UsernamePasswordToken设置记住我
            usernamePasswordToken.setRememberMe(rememberMe);

            try{
                //登录认证+授权
                subject.login(usernamePasswordToken);
                session.setAttribute("userName",username);
                return ResultUtils.success();
            }catch (AuthenticationException ae){ /* 抛出的异常全为AuthenticationException的子类 */
//                System.out.println("登陆失败：" + ae.toString());
                return ResultUtils.error(-1,"登录失败");
            }
        }
        return ResultUtils.error(-1,"登录失败");
    }

    @RequestMapping(value = "register",method = RequestMethod.POST)
    @ResponseBody
    public Result register(User user){
        String userPw = user.getUserPw();
        String userName = user.getUserName();
        Object passwordMD5 = MD5Utils.stringToMD5(userPw);
        user.setUserPw(passwordMD5.toString());
        Integer result = userService.insertUser(user);
        if (result != null){
            return ResultUtils.success();
        }else{
            return ResultUtils.error(-1,"注册失败");
        }
    }
}
