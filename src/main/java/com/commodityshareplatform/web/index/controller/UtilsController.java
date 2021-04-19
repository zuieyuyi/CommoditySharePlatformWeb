package com.commodityshareplatform.web.index.controller;

import com.commodityshareplatform.web.utils.MD5Utils;
import com.commodityshareplatform.web.utils.Result;
import com.commodityshareplatform.web.utils.ResultUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("utils")
public class UtilsController {

    /**
     * 解析密码
     * @param password 密码
     * @return
     */
    @RequestMapping(value = "parsePwd",method = RequestMethod.POST)
    @ResponseBody
    public Result parsePwd(@RequestParam("password") String password){
        try{
            Object parsePwd = MD5Utils.stringToMD5(password);
            return ResultUtils.success(parsePwd.toString());
        }catch (Exception e){
            return ResultUtils.error(-1,"密码解析失败");
        }
    }
}
