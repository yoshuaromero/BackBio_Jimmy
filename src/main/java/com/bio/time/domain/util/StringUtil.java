package com.bio.time.domain.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.bio.time.domain.dto.EncrypDto;
import com.bio.time.domain.exception.HttpGenericException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Component
public class StringUtil {

    private final Log logger = LogFactory.getLog(getClass());
    private static final String AES = "AES";
    private static final byte[] IV_SPEC = { 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00 };
    private static final String NUMBERS = "0123456789";
    private static final String CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789#()[]";
    @Autowired private PasswordEncoder passwordEncoder;
    @Value("${crypto.secret}") private String secret;
    @Value("${crypto.algorithm}") private String algorithm;

    public Map<String,String> generateOPT(int size) throws HttpGenericException, JsonProcessingException {
        Map<String, String> data = new HashMap<>();
        String response="";
        SecureRandom sr = new SecureRandom();

        for(int i=0;i<size;i++) {
            response += NUMBERS.charAt(sr.nextInt(NUMBERS.length()));
        }
        //String pw = this.encode(response);
        EncrypDto dataEncryp = new EncrypDto();
        dataEncryp.setOpt(response);
        dataEncryp.setDate(LocalDateTime.now());
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        String dataEncAsString = "";
        try {
            dataEncAsString = objectMapper.writeValueAsString(dataEncryp);
        } catch (IOException e1) {
            throw new HttpGenericException(HttpStatus.INTERNAL_SERVER_ERROR, "Error => " + e1);
        }
        data.put("opt", response);
        data.put("encrypt", this.encryptOpt(dataEncAsString));
        return data;
    }
    public Map<String,String> generatePassword(int size) throws HttpGenericException, JsonProcessingException {
        Map<String, String> data = new HashMap<>();
        String response="";
        SecureRandom sr = new SecureRandom();
        for(int i=0;i<size;i++) {
            response += CHARS.charAt(sr.nextInt(CHARS.length()));
        }
        String pw = passwordEncoder.encode(response);
        data.put("pwd", response);
        data.put("encrypt", pw);
        return data;
    }
    public String encryptOpt(String value) {
        try {
            IvParameterSpec iv = new IvParameterSpec(IV_SPEC);
            SecretKeySpec skeySpec = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), AES);
            Cipher cipher = Cipher.getInstance(algorithm);
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(value.getBytes());
            byte[] encryptedBytes = Base64.getUrlEncoder().encode(encrypted);
            return new String(encryptedBytes, StandardCharsets.UTF_8);
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException
                 | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException ex) {
            logger.error("Error encrypting: " + ex.getMessage());
            return null;
        }
    }
    public String decryptOpt(String encrypted) {
        try {
            IvParameterSpec iv = new IvParameterSpec(IV_SPEC);
            SecretKeySpec skeySpec = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), AES);
            Cipher cipher = Cipher.getInstance(algorithm);
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

            byte[] encryptedBytes = Base64.getUrlDecoder().decode(encrypted.getBytes(StandardCharsets.UTF_8));
            byte[] decrypted = cipher.doFinal(encryptedBytes);
            return new String(decrypted);
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException
                 | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException ex) {
            logger.error("Error decrypting: " + ex.getMessage());
            return null;
        }
    }
}
