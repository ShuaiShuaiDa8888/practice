package com.shiro.utils;


import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * Created by WS on 2018/5/12.
 */
public class CrypographyUtils {

    /**
     * Base64 加密
     *
     * @param str
     * @return
     */
    public static String encBase64(String str){
        return Base64.encodeToString(str.getBytes());
    }

    /**
     * Base64 解密
     *
     * @param str
     * @return
     */
    public static String decBase64(String str){
        return Base64.decodeToString(str);
    }

    /**
     * MD5加密
     *
     * @param str
     * @param salt
     * @return
     */
    public static String md5(String str, String salt){
         return new Md5Hash(str, salt).toString();
    }

    public static void main(String[] args) {
        String password = "345";
        System.out.println("Base64 加密: " + CrypographyUtils.encBase64(password));
        System.out.println("Base64 解密: " + CrypographyUtils.decBase64("MTIzNDU2"));

        System.out.println("MD5 加密: " + CrypographyUtils.md5(password, "盐"));
    }
}
