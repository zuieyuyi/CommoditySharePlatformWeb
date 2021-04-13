package com.commodityshareplatform.web.index.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
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
    public String to_showpage(){
        return "commodityWeb/showpage";
    }
}
