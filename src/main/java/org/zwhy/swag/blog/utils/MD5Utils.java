package org.zwhy.swag.blog.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author ZWHySwag
 * @date 2021\7\30 0030 14:52
 */
public class MD5Utils {

    /**
     *
     * @param orgStr 明文密码
     * @return  加密后的密码
     */
    public static String encode(String orgStr) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(orgStr.getBytes());
            byte[] digest = md.digest();
            StringBuffer buffer = new StringBuffer();
            for (int offset = 0; offset < digest.length; offset++) {
                int offsetVal = digest[offset];
                if (offsetVal < 0) {
                    offsetVal += 256;
                }
                if (offsetVal < 16) {
                    buffer.append(0);
                }
                buffer.append(Integer.toHexString(offsetVal));
            }
            //32位加密
            return buffer.toString();
            //16位加密
            //return buffer.toString().substring(8, 24);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(encode("zww@19930809"));
    }

}
