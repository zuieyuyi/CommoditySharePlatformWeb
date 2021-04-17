package com.commodityshareplatform.web.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
    /**
     *
     * @param credentials   密码
     * @param saltStr   盐值
     * @return
     */
    public static Object stringToMD5Salt(Object credentials,String saltStr) {
        String hashAlgorithmName = "MD5";//加密类型
        ByteSource salt = ByteSource.Util.bytes(saltStr);//盐值
        int hashIterations = 100;//加密次数

        Object simpleHash = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
//        Object simpleHash1 = new SimpleHash(hashAlgorithmName, credentials);
        return simpleHash;
    }

    /**
     *
     * @param credentials   密码
     * @return
     */
    public static Object stringToMD5(Object credentials) {
        String hashAlgorithmName = "MD5";//加密类型
//        ByteSource salt = ByteSource.Util.bytes(saltStr);//盐值
        int hashIterations = 100;//加密次数

//        Object simpleHash = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
        Object simpleHash1 = new SimpleHash(hashAlgorithmName,credentials,null,hashIterations);
        return simpleHash1;
    }
}
