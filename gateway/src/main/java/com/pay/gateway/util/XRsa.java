package com.pay.gateway.util;
import java.io.ByteArrayOutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import org.apache.commons.codec.binary.Base64;
import org.apache.tomcat.util.http.fileupload.IOUtils;


public class XRsa {

	public static final String CHARSET = "UTF-8";
    public static final String RSA_ALGORITHM = "RSA";
    public static final String RSA_ALGORITHM_SIGN = "SHA256WithRSA";
 
    private RSAPublicKey publicKey;
    private RSAPrivateKey privateKey;
 
    public static void main(String[] args) {
    	Map<String, String> createKeys = createKeys(512);
    	System.out.println("公钥："+createKeys.get("publicKey"));
    	System.out.println("私钥："+createKeys.get("privateKey"));
    	System.out.println("公钥加密");
    	System.out.println("加密内容："+"accountId=AC1000&amount=200&backCard=65465443213213&userName=%E7%9C%9F%E5%AE%9E%E6%95%B0%E6%8D%AE%E6%B5%8B%E8%AF%95&userId=test&ipAddr=127.0.0.1");
    	XRsa aa = new XRsa(createKeys.get("publicKey"), createKeys.get("privateKey"));
    	String publicEncrypt = aa.publicEncrypt("accountId=AC1000&amount=200&backCard=65465443213213&userName=%E7%9C%9F%E5%AE%9E%E6%95%B0%E6%8D%AE%E6%B5%8B%E8%AF%95&userId=test&ipAddr=127.0.0.1");
    	System.out.println("公钥加密后的内容："+publicEncrypt);
    	String privateEncrypt = aa.privateEncrypt("accountId=AC1000&amount=200&backCard=65465443213213&userName=%E7%9C%9F%E5%AE%9E%E6%95%B0%E6%8D%AE%E6%B5%8B%E8%AF%95&userId=test&ipAddr=127.0.0.1");
    	System.out.println("私钥加密后的内容："+privateEncrypt);
    	//String privateDecrypt = aa.privateDecrypt(privateEncrypt);
    //	System.out.println("私钥解密私钥的加密内容："+privateDecrypt);
    	String privateDecrypt2 = aa.privateDecrypt(publicEncrypt);
    	System.out.println("私钥解密公钥内容："+privateDecrypt2);
    	String publicDecrypt = aa.publicDecrypt(privateEncrypt);
    	System.out.println("公钥解密私钥加密后内容："+publicDecrypt);
	}
    
    
    public XRsa(String publicKey, String privateKey) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
 
            //通过X509编码的Key指令获得公钥对象
            X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(Base64.decodeBase64(publicKey));
            this.publicKey = (RSAPublicKey) keyFactory.generatePublic(x509KeySpec);
            //通过PKCS#8编码的Key指令获得私钥对象
            PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKey));
            this.privateKey = (RSAPrivateKey) keyFactory.generatePrivate(pkcs8KeySpec);
        } catch (Exception e) {
            throw new RuntimeException("不支持的密钥", e);
        }
    }
 
    public static Map<String, String> createKeys(int keySize){
        //为RSA算法创建一个KeyPairGenerator对象
        KeyPairGenerator kpg;
        try{
            kpg = KeyPairGenerator.getInstance(RSA_ALGORITHM);
        }catch(NoSuchAlgorithmException e){
            throw new IllegalArgumentException("No such algorithm-->[" + RSA_ALGORITHM + "]");
        }
 
        //初始化KeyPairGenerator对象,不要被initialize()源码表面上欺骗,其实这里声明的size是生效的
        kpg.initialize(keySize);
        //生成密匙对
        KeyPair keyPair = kpg.generateKeyPair();
        //得到公钥
        Key publicKey = keyPair.getPublic();
        String publicKeyStr = Base64.encodeBase64URLSafeString(publicKey.getEncoded());
        //得到私钥
        Key privateKey = keyPair.getPrivate();
        String privateKeyStr = Base64.encodeBase64URLSafeString(privateKey.getEncoded());
        Map<String, String> keyPairMap = new HashMap<String, String>();
        keyPairMap.put("publicKey", publicKeyStr);
        keyPairMap.put("privateKey", privateKeyStr);
 
        return keyPairMap;
    }
 
    /**
     * <p>私钥加密</p>
     * @param data
     * @return
     */
    public String publicEncrypt(String data){
        try{
            Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            return Base64.encodeBase64URLSafeString(rsaSplitCodec(cipher, Cipher.ENCRYPT_MODE, data.getBytes(CHARSET), publicKey.getModulus().bitLength()));
        }catch(Exception e){
            throw new RuntimeException("加密字符串[" + data + "]时遇到异常", e);
        }
    }
 
    /**
     * <p>私钥解密</p>
     * @param data
     * @return
     */
    public String privateDecrypt(String data){
        try{
            Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            return new String(rsaSplitCodec(cipher, Cipher.DECRYPT_MODE, Base64.decodeBase64(data), publicKey.getModulus().bitLength()), CHARSET);
        }catch(Exception e){
            throw new RuntimeException("解密字符串[" + data + "]时遇到异常", e);
        }
    }
 
    /**
     * <p>私钥加密</p>
     * @param data
     * @return
     */
    public String privateEncrypt(String data){
        try{
            Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, privateKey);
            return Base64.encodeBase64URLSafeString(rsaSplitCodec(cipher, Cipher.ENCRYPT_MODE, data.getBytes(CHARSET), publicKey.getModulus().bitLength()));
        }catch(Exception e){
            throw new RuntimeException("加密字符串[" + data + "]时遇到异常", e);
        }
    }
 
    /**
     * <p>公钥解密</p>
     * @param data
     * @return
     */
    public String publicDecrypt(String data){
        try{
            Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, publicKey);
            return new String(rsaSplitCodec(cipher, Cipher.DECRYPT_MODE, Base64.decodeBase64(data), publicKey.getModulus().bitLength()), CHARSET);
        }catch(Exception e){
            throw new RuntimeException("解密字符串[" + data + "]时遇到异常", e);
        }
    }
 
    /**
     * <p>签名</p>
     * @param data
     * @return
     */
    public String sign(String data){
        try{
            //sign
            Signature signature = Signature.getInstance(RSA_ALGORITHM_SIGN);
            signature.initSign(privateKey);
            signature.update(data.getBytes(CHARSET));
            return Base64.encodeBase64URLSafeString(signature.sign());
        }catch(Exception e){
            throw new RuntimeException("签名字符串[" + data + "]时遇到异常", e);
        }
    }
 
    /**
     * <p>验签的方法</p>
     * @param data
     * @param sign
     * @return
     */
    public boolean verify(String data, String sign){
        try{
            Signature signature = Signature.getInstance(RSA_ALGORITHM_SIGN);
            signature.initVerify(publicKey);
            signature.update(data.getBytes(CHARSET));
            return signature.verify(Base64.decodeBase64(sign));
        }catch(Exception e){
            throw new RuntimeException("验签字符串[" + data + "]时遇到异常", e);
        }
    }
 
    private static byte[] rsaSplitCodec(Cipher cipher, int opmode, byte[] datas, int keySize){
        int maxBlock = 0;
        if(opmode == Cipher.DECRYPT_MODE){
            maxBlock = keySize / 8;
        }else{
            maxBlock = keySize / 8 - 11;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] buff;
        int i = 0;
        try{
            while(datas.length > offSet){
                if(datas.length-offSet > maxBlock){
                    buff = cipher.doFinal(datas, offSet, maxBlock);
                }else{
                    buff = cipher.doFinal(datas, offSet, datas.length-offSet);
                }
                out.write(buff, 0, buff.length);
                i++;
                offSet = i * maxBlock;
            }
        }catch(Exception e){
            throw new RuntimeException("加解密阀值为["+maxBlock+"]的数据时发生异常", e);
        }
        byte[] resultDatas = out.toByteArray();
        IOUtils.closeQuietly(out);
        return resultDatas;
    }
}
