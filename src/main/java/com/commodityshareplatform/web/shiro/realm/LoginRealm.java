package com.commodityshareplatform.web.shiro.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * 1. 授权需要继承 AuthorizingRealm 类, 并实现其 doGetAuthorizationInfo 方法
 * 2. AuthorizingRealm 类继承自 AuthenticatingRealm, 但没有实现 AuthenticatingRealm 中的
 * doGetAuthenticationInfo, 所以认证和授权只需要继承 AuthorizingRealm 就可以了. 同时实现他的两个抽象方法.
 */
public class LoginRealm extends AuthorizingRealm {
    /**
     * 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //将AuthenticationToken强转
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //通过UsernamePasswordToken获取用户名以及密码的信息
        String username = token.getUsername();
        char[] password = token.getPassword();

        //判断查询用户情况，判断是否有改用户
        System.out.println("从数据库获取用户数据");

        //判断用户情况，抛出异常
        //用户不存在，抛出异常
        if ("unknown".equals(username)){
            throw new UnknownAccountException("用户不存在");
        }
        //如果用户被锁定，抛出异常
        if ("monster".equals(username)){
            throw new LockedAccountException("用户被锁定");
        }

        //6. 根据用户的情况, 来构建 AuthenticationInfo 对象并返回. 通常使用的实现类为: SimpleAuthenticationInfo
        //以下信息是从数据库中获取的.
        //1). principal: 认证的实体信息. 可以是 username, 也可以是数据表对应的用户的实体类对象.
        Object principal = username;
        //2). credentials: 密码.（加密方式在配置文件中通过credentialsMatcher属性配置）
        Object credentials = "e10adc3949ba59abbe56e057f20f883e"; /* 123456的加密结果 MD5加密1次 */

        //3). realmName: 当前 realm 对象的 name. 调用父类的 getName() 方法即可
        String realmName = getName();
        //4). 盐值.（防止用户同密码的状况）
        //通过该方法获取盐值（传入的属性必须是唯一的）
//        ByteSource credentialsSalt = ByteSource.Util.bytes(username);
        //输入的用户名、密码加密后的值、盐值必须和传入的值一样，才可获取认证
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, realmName);
//        info = new SimpleAuthenticationInfo(principal, credentials, credentialsSalt, realmName);
        return info;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
}

