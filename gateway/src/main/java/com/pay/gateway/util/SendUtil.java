package com.pay.gateway.util;


import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import cn.hutool.http.HttpUtil;

@Component
public class SendUtil {
	private final String privateKey = "MIIBVQIBADANBgkqhkiG9w0BAQEFAASCAT8wggE7AgEAAkEAu0wb+QnOIwVPMj3hs1Q6pFuLLdQFdc9baTRMPw6X+x3Lhmrk16AGep6ggcvFKEAWyZmyg33gmgZwJMGoWj1utQIDAQABAkB9lv5W0p1X3FKLhPUX043y8bN0ymvS4HUSKVBLJBUC+4GUpH4ng/4NkA3hYoa91AJfK/kQ7PTuTNIbdzUzLkntAiEA/uQS8RMT41P/ZUQofiDDgUGRuFgL+vsOgR387QextfMCIQC8HL3wlkZfwvcVKDuQ5OEICpzc8Ci2ZfTEogPnrluqtwIhAL620CVo7NyPIO0YTmPxB9dSxEF2P6CO8I9TbMe9lg5ZAiEAhGV+UcySr2ebW6q7cdmFgJFnoiDtpqLPyW12biPLpLUCIDU0PmBhO3nomUgNdUwyQESFPBKh0T9Y0w3Dh1x8mb/F\r\n" ; 
	private final String publicKey ="MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBALtMG/kJziMFTzI94bNUOqRbiy3UBXXPW2k0TD8Ol/sdy4Zq5NegBnqeoIHLxShAFsmZsoN94JoGcCTBqFo9brUCAwEAAQ==\r\n"; //new String(Base64.encodeBase64(keyPair.getPublic().getEncoded()));
	private String getPrivateKey() {
		return privateKey;
	}
	private String getPublicKey() {
		return publicKey;
	}
	/**
	 * <p>对参数进行加密</p>
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Map<String ,Object > careteParam(Map<String,Object> map) throws Exception {
		System.out.println("私钥:" + privateKey);
        System.out.println("公钥:" + publicKey);
		String params = HttpUtil.toParams(map);
         String encryptData = encrypt(params, getPublicKey(publicKey));
         System.out.println("加密后内容:" + encryptData);
         String sign = sign(params, getPrivateKey(privateKey));
         Map<String ,Object > parasMap = new HashMap<String,Object>();
         parasMap.put("MD5",encryptData);
         parasMap.put("sign",sign);
		return parasMap;
	}
	public HashMap<String, String> decryptionParam(HttpServletRequest request) throws Exception{
		String MD5 = request.getParameter("MD5");//参数加密结果  这是要解密的值
		String sign = request.getParameter("sign");// 这是 签名之后的值
		String decryptData = decrypt(MD5, getPrivateKey(privateKey));
        System.out.println("解密后内容:" + decryptData);
        boolean result = verify(decryptData, getPublicKey(publicKey), sign);
        HashMap<String, String> decodeParamMap = HttpUtil.decodeParamMap(decryptData,"UTF-8");
		return decodeParamMap;
	}
	    /**
	     * RSA最大加密明文大小
	     */
	    private static final int MAX_ENCRYPT_BLOCK = 117;
	    /**
	     * RSA最大解密密文大小
	     */
	    private static final int MAX_DECRYPT_BLOCK = 128;
	    /**
	     * 获取密钥对
	     * 
	     * @return 密钥对
	     */
	    private static KeyPair getKeyPair() throws Exception {
	        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
	        generator.initialize(512);
	        return generator.generateKeyPair();
	    }
	    /**
	     * 获取私钥
	     * 
	     * @param privateKey 私钥字符串
	     * @return
	     */
	    private static PrivateKey getPrivateKey(String privateKey) throws Exception {
	        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
	        byte[] decodedKey = Base64.decodeBase64(privateKey.getBytes());
	        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(decodedKey);
	        return keyFactory.generatePrivate(keySpec);
	    }
	    /**
	     * 获取公钥
	     * 
	     * @param publicKey 公钥字符串
	     * @return
	     */
	    private static PublicKey getPublicKey(String publicKey) throws Exception {
	        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
	        byte[] decodedKey = Base64.decodeBase64(publicKey.getBytes());
	        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(decodedKey);
	        return keyFactory.generatePublic(keySpec);
	    }
	    /**
	     * RSA加密
	     * 
	     * @param data 待加密数据
	     * @param publicKey 公钥
	     * @return
	     */
	    private static String encrypt(String data, PublicKey publicKey) throws Exception {
	        Cipher cipher = Cipher.getInstance("RSA");
	        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
	        int inputLen = data.getBytes().length;
	        ByteArrayOutputStream out = new ByteArrayOutputStream();
	        int offset = 0;
	        byte[] cache;
	        int i = 0;
	        // 对数据分段加密
	        while (inputLen - offset > 0) {
	            if (inputLen - offset > MAX_ENCRYPT_BLOCK) {
	                cache = cipher.doFinal(data.getBytes(), offset, MAX_ENCRYPT_BLOCK);
	            } else {
	                cache = cipher.doFinal(data.getBytes(), offset, inputLen - offset);
	            }
	            out.write(cache, 0, cache.length);
	            i++;
	            offset = i * MAX_ENCRYPT_BLOCK;
	        }
	        byte[] encryptedData = out.toByteArray();
	        out.close();
	        // 获取加密内容使用base64进行编码,并以UTF-8为标准转化成字符串
	        // 加密后的字符串
	        return new String(Base64.encodeBase64String(encryptedData));
	    }
	    /**
	     * RSA解密
	     * 
	     * @param data 待解密数据
	     * @param privateKey 私钥
	     * @return
	     */
	    private static String decrypt(String data, PrivateKey privateKey) throws Exception {
	        Cipher cipher = Cipher.getInstance("RSA");
	        cipher.init(Cipher.DECRYPT_MODE, privateKey);
	        byte[] dataBytes = Base64.decodeBase64(data);
	        int inputLen = dataBytes.length;
	        ByteArrayOutputStream out = new ByteArrayOutputStream();
	        int offset = 0;
	        byte[] cache;
	        int i = 0;
	        // 对数据分段解密
	        while (inputLen - offset > 0) {
	            if (inputLen - offset > MAX_DECRYPT_BLOCK) {
	                cache = cipher.doFinal(dataBytes, offset, MAX_DECRYPT_BLOCK);
	            } else {
	                cache = cipher.doFinal(dataBytes, offset, inputLen - offset);
	            }
	            out.write(cache, 0, cache.length);
	            i++;
	            offset = i * MAX_DECRYPT_BLOCK;
	        }
	        byte[] decryptedData = out.toByteArray();
	        out.close();
	        // 解密后的内容 
	        return new String(decryptedData, "UTF-8");
	    }
	    /**
	     * 签名
	     * 
	     * @param data 待签名数据
	     * @param privateKey 私钥
	     * @return 签名
	     */
	    private static String sign(String data, PrivateKey privateKey) throws Exception {
	        byte[] keyBytes = privateKey.getEncoded();
	        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
	        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
	        PrivateKey key = keyFactory.generatePrivate(keySpec);
	        Signature signature = Signature.getInstance("MD5withRSA");
	        signature.initSign(key);
	        signature.update(data.getBytes());
	        return new String(Base64.encodeBase64(signature.sign()));
	    }
	    /**
	     * 验签
	     * 
	     * @param srcData 原始字符串
	     * @param publicKey 公钥
	     * @param sign 签名
	     * @return 是否验签通过
	     */
	    private static boolean verify(String srcData, PublicKey publicKey, String sign) throws Exception {
	        byte[] keyBytes = publicKey.getEncoded();
	        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
	        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
	        PublicKey key = keyFactory.generatePublic(keySpec);
	        Signature signature = Signature.getInstance("MD5withRSA");
	        signature.initVerify(key);
	        signature.update(srcData.getBytes());
	        return signature.verify(Base64.decodeBase64(sign.getBytes()));
	    }
	  /*  public static void main(String[] args) {
	        try {
	            // 生成密钥对
	            KeyPair keyPair = getKeyPair();
	            String publicKey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAJH3Vff5y8BAOcIKfg/7Zl1wsiOKG5JeFaxxrMrrPMRNvhEVyhWjI01wlXjc4qnUD9A8EQxsDGNZPZd8UQN1++cCAwEAAQ==";
	            		
	            		
	            		//new String(Base64.encodeBase64(keyPair.getPrivate().getEncoded()));
	            String privateKey = "MIIBVgIBADANBgkqhkiG9w0BAQEFAASCAUAwggE8AgEAAkEAkfdV9/nLwEA5wgp+D/tmXXCyI4obkl4VrHGsyus8xE2+ERXKFaMjTXCVeNziqdQP0DwRDGwMY1k9l3xRA3X75wIDAQABAkAkQUDTJPJcwBcYgS6qnZDhaJp2hVkv07qiaGG4zRD82Mpk25NjciNBcut8kUQmNvu4Niz75Z2b3C/RHsUbGXghAiEAyCFegfQ1ABf0ZcCleA5d/Djo7boNOJXyK5sByfpvjikCIQC6twmHXhR76g6OZxYIcvZ4ga+34B80Z38bFlL8pFVbjwIhALEcjvX1OD539KtkPUwtctG3T7SrVe4BDYu3p3KndrhZAiEAg7tr76PC1AI4ruOwOdnSZwcokJSBr5ltphDEEBdpWaUCIQCLA6/qQgpQUsW9GCAIQOwmLuNK1QJ11LTbMYsB0K0How==";
	            
	            		//new String(Base64.encodeBase64(keyPair.getPublic().getEncoded()));
	            System.out.println("私钥:" + privateKey);
	            System.out.println("公钥:" + publicKey);
	            // RSA加密
	            String data = "appid=10024/min=653";
	            String encryptData = encrypt(data, getPublicKey(publicKey));
	            System.out.println("加密后内容:" + encryptData);
	            // RSA解密
	            String decryptData = decrypt(encryptData, getPrivateKey(privateKey));
	            System.out.println("解密后内容:" + decryptData);
	            // RSA签名
	            String sign = sign(data, getPrivateKey(privateKey));
	            // RSA验签
	            boolean result = verify(data, getPublicKey(publicKey), sign);
	            System.out.print("验签结果:" + result);
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.print("加解密异常");
	        }
	    }
	*/
	
	
}
