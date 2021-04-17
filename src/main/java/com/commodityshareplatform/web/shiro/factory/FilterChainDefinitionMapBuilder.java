package com.commodityshareplatform.web.shiro.factory;

import java.util.LinkedHashMap;

public class FilterChainDefinitionMapBuilder {

    /**
     * 可以通过该方法从数据库中读出要保护的页面
     */
    public LinkedHashMap<String,String> filterChainDefinitionMapBuilder(){

        LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap<>();
//        1). anon 可以被匿名访问
//        2). authc 必须认证(即登录)后才可能访问的页面.
//        3). logout 登出.
//        4). roles 角色过滤器

        //从数据库中读取的数据
        //过滤静态资源
        linkedHashMap.put("/static/**","anon");
        //过滤
        linkedHashMap.put("/login","anon");
        linkedHashMap.put("/to_login","anon");
        linkedHashMap.put("/to_register","anon");
        linkedHashMap.put("/register","anon");
        linkedHashMap.put("/index","anon");
        linkedHashMap.put("/to_showpage","anon");
        linkedHashMap.put("/to_commoditypage","anon");
        linkedHashMap.put("/commodity/**","anon");
        linkedHashMap.put("/comment/**","anon");
        linkedHashMap.put("/user/users","anon");
        linkedHashMap.put("/**","authc");

        return linkedHashMap;
    }

}