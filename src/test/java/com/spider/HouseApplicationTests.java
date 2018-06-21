package com.spider;

import org.springframework.util.Base64Utils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class HouseApplicationTests {
    private static String sKey = "0CoJUm6Qyw8W8jud";
    private static String ivParameter = "0102030405060708";
    private static String context = "{rid: \"R_SO_4_25641368\",offset: \"0\",total: \"true\",limit: \"20\",csrf_token: \"\"}";

    public void contextLoads() {


    }

    public static void main(String[] args) throws Exception {
        String result = AESEncrypt(AESEncrypt(context, sKey, ivParameter), "FFFFFFFFFFFFFFFF", ivParameter);
        System.out.println(result);
    }

    private String rsaEncrypt() {
        String secKey = "257348aecb5e556c066de214e531faadd1c55d814f9be95fd06d6bff9f4c7a41f831f6394d5a3fd2e3881736d94a02ca919d952872e7d0a50ebfa1769a7a62d512f5f1ca21aec60bc3819a9c3ffca5eca9a0dba6d6f7249b06f5965ecfff3695b54e1c28f3f624750ed39e7de08fc8493242e26dbc4484a01c76f739e135637c";
        return secKey;
    }

    private static String AESEncrypt(String content, String sKey, String ivParameter) {
        try {
            byte[] encryptedBytes;
            byte[] byteContent = content.getBytes("UTF-8");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec secretKeySpec = new SecretKeySpec(sKey.getBytes(), "AES");

            IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());

            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, iv);
            encryptedBytes = cipher.doFinal(byteContent);
//            System.out.println(Base64Utils.encode(encryptedBytes));
            return new String(Base64Utils.encode(encryptedBytes), "UTF-8");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

}
