package test;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESUtil {

    //初始化向量，aes 16位
    private static final String IV = "aef01238765abcde";

    //加密
    public static String encrypt(String content, String keyWord) throws Exception {
        try {
            SecretKeySpec key = new SecretKeySpec(keyWord.getBytes("UTF-8"), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(IV.getBytes()));
            byte[] encryptedData = cipher.doFinal(content.getBytes("UTF-8"));
            return Base64.getEncoder().encodeToString(encryptedData);
        } catch (Exception e) {
            throw new Exception("加密失败");
        }
    }

    // 解密
    public static String decrypt(String content, String keyWord) throws Exception {
        byte[] decode = Base64.getDecoder().decode(content);
        try {
            SecretKeySpec key = new SecretKeySpec(keyWord.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(IV.getBytes()));
            byte[] result = cipher.doFinal(decode);
            return new String(result);
        } catch (Exception e) {
            throw new Exception("解密失败");
        }
    }

    //二进制转变为16进制
    public static String parseByte2HexStr(byte[] buf) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex);
        }
        return sb.toString();
    }

    //将16进制转变为二进制
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1) {
            return null;
        }
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    public static void main(String[] args) throws Exception {

        String content = "430321199104011716";
//        String content = "hello world";
        //此处使用AES-128-CBC加密模式，key需要为16位
        String password = "aef01238765abcde";

        System.out.println("加密前：" + content);
        String encryptResult = AESUtil.encrypt(content, password);
        System.out.println("加密后：" + encryptResult);
        String decryptResult = AESUtil.decrypt(encryptResult, password);
        System.out.println("解密后：" + decryptResult);

        String decrypt = AESUtil.decrypt("sZJ9TVbkIe7GLZGrj0BLT/88G3xBLO5lQivzlxdbEc8=", password);
        System.out.println("解密后：" + decrypt);
    }

}