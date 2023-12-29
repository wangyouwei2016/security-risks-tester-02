package com.example.demo.risk;
import javax.crypto.Cipher;  
import javax.crypto.spec.SecretKeySpec;  
import java.nio.charset.StandardCharsets;  
import java.util.Base64;  
/**
 * 
 * A02:2021-Cryptographic Failures 是指在软件或系统中由于加密算法、加密密钥、加密操作等方面的问题导致的加密失败或加密不安全的情况。
 * 风险点： 密码明文
 *       不安全的加密方式
 */


public class CryptographicFailure {
	public static void cryptographicFailure() throws Exception {
        String clearText = "Hello, World!";  
        String key = "password12345678"; // 使用明文密码作为密钥  
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding"); // 使用不安全的加密模式  
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");  
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);  
        String encryptedText = Base64.getEncoder().encodeToString(cipher.doFinal(clearText.getBytes(StandardCharsets.UTF_8)));  
        System.out.println("Encrypted Text: " + encryptedText);  
		
	}
}
