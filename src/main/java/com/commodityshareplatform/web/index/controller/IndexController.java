package com.commodityshareplatform.web.index.controller;

import com.commodityshareplatform.web.user.bean.User;
import com.commodityshareplatform.web.user.bean.UserExample;
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
import java.util.List;
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

    @RequestMapping(value = "to_mypage",method = RequestMethod.GET)
    public String to_mypage(){
        return "commodityWeb/mypage";
    }

    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:to_login";
    }

    /**
     * ??????
     * @param username
     * @param password
     * @param rememberMe
     * @param session
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.POST)
    @ResponseBody
    public Result login(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("rememberMe") Boolean rememberMe , HttpSession session){
        Subject subject = SecurityUtils.getSubject();

        //??????????????????????????????????????????????????????,?????????????????????????????????
        if(!subject.isAuthenticated()){
            //1????????????????????????????????????????????????UsernamePasswordToken
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,password);
            //?????????????????????????????????
            //??????UsernamePasswordToken???????????????
            usernamePasswordToken.setRememberMe(rememberMe);

            try{
                //????????????+??????
                subject.login(usernamePasswordToken);
                //???????????????????????????session
                UserExample ex = new UserExample();
                UserExample.Criteria criteria = ex.createCriteria();
                criteria.andUserNameEqualTo(username);
                List<User> users = userService.selectUserByEx(ex);
                User user = users.get(0);
                session.setAttribute("userName",username);
                session.setAttribute("userId",user.getUserId());
                return ResultUtils.success();
            }catch (AuthenticationException ae){ /* ?????????????????????AuthenticationException????????? */
//                System.out.println("???????????????" + ae.toString());
                return ResultUtils.error(-1,"????????????");
            }
        }
        return ResultUtils.error(-1,"????????????");
    }

    /**
     * ??????
     * @param user
     * @return
     */
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
            return ResultUtils.error(-1,"????????????");
        }
    }
}
