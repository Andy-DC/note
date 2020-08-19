package com.demo.common.util;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * EncryptionUtils
 *
 * @author dengce
 * @date 2017/10/8
 * @description 加密算法类
 */
public class EncryptionUtils {


    private final static String DES = "DES";
    /**
     * MD5加密算法进行加密
     * @param source
     * @return
     * @throws Exception
     */
    public static String getMD5(byte[] source)throws Exception
    {
        String s = null;
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f' };
            MessageDigest md = MessageDigest
                    .getInstance("MD5");
            md.update(source);
            byte tmp[] = md.digest();
            char str[] = new char[16 * 2];
            int k = 0;
            for (int i = 0; i < 16; i++) {
                byte byte0 = tmp[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            s = new String(str);
        return s;
    }


    /**
     * SHA1算法进行加密
     * @param decript
     * @return
     * @throws Exception
     */
    public static String getSHA1(String decript)throws Exception
    {
        MessageDigest digest = MessageDigest
                .getInstance("SHA-1");
        digest.update(decript.getBytes());
        byte messageDigest[] = digest.digest();
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < messageDigest.length; i++)
        {
            String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
            if (shaHex.length() < 2) {
                hexString.append(0);
            }
            hexString.append(shaHex);
        }
        return hexString.toString();
    }


    /**
     * 使用 默认key 加密
     *
     * @return String
     * @author lifq
     * @date 2015-3-17 下午02:46:43
     */
    public static String encrypt(String data,String secret) throws Exception {
        byte[] bt = encrypt(data.getBytes("UTF-8"), secret.getBytes("UTF-8"));
        //String strs = new BASE64Encoder().encode(bt);
        String strs = Base64.getEncoder().encodeToString(bt);
        return strs;
    }

    /**
     * Description 根据键值进行加密
     *
     * @param data
     * @param key
     *            加密键byte数组
     * @return
     * @throws Exception
     */
    private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();

        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);

        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);

        // Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance(DES);

        // 用密钥初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);

        return cipher.doFinal(data);
    }


    /**
     * DES加密
     * @param datasource
     * @param password
     * @return
     * @throws Exception
     */
    public static String DESEncrypt(byte[] datasource, String password)throws Exception
    {
        String result = null;
        SecureRandom random = new SecureRandom();
        DESKeySpec desKey = new DESKeySpec(password.getBytes("UTF-8"));
        //创建一个密匙工厂，然后用它把DESKeySpec转换成
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey securekey = keyFactory.generateSecret(desKey);
        //Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance("DES");
        //用密匙初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
        //现在，获取数据并加密
        //正式执行加密操作
        byte[]  bytes =  cipher.doFinal(datasource);
        result = Base64.getEncoder().encodeToString(bytes);
        return result;
    }



    public static String DESDecrypt(byte[] src, String password)throws Exception
    {
        String result = null;
        // DES算法要求有一个可信任的随机数源
        SecureRandom random = new SecureRandom();
        // 创建一个DESKeySpec对象
                DESKeySpec desKey = new DESKeySpec(password.getBytes());
        // 创建一个密匙工厂
                SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        // 将DESKeySpec对象转换成SecretKey对象
                SecretKey securekey = keyFactory.generateSecret(desKey);
        // Cipher对象实际完成解密操作
                Cipher cipher = Cipher.getInstance("DES");
        // 用密匙初始化Cipher对象
                cipher.init(Cipher.DECRYPT_MODE, securekey, random);
        // 真正开始解密操作
                byte[] bytes =  cipher.doFinal(src);
        result = new String(Base64.getDecoder().decode(bytes),"UTF-8");
        return result;
    }
}
