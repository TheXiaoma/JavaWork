package com.xiaoma.java.project.hwid;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

public class GenerateHWID {

    public static void main(String[] args) throws Exception {
        System.out.println(getEncryptedHardwareId("secret114514"));
    }

    public static String getEncryptedHardwareId(String key) throws Exception {
        // 加密算法名称
        final String ALGORITHM_NAME = "AES";
        // 摘要算法名称
        final String DIGEST_ALGORITHM_NAME = "SHA-256";
        // 密钥长度（单位：比特）
        final int KEY_LENGTH_BITS = 128;
        // 块大小（单位：字节）
        final int BLOCK_SIZE_BYTES = 16;

        // 获取 CPU ID
        Process cpuProcessHandle = Runtime.getRuntime().exec("wmic cpu get ProcessorId");
        BufferedReader cpuStreamReader = new BufferedReader(new InputStreamReader(cpuProcessHandle.getInputStream()));
        cpuStreamReader.readLine();
        String cpuId = cpuStreamReader.readLine().trim();
        cpuStreamReader.close();

        // 获取硬盘序列号
        Process diskProcessHandle = Runtime.getRuntime().exec("wmic diskdrive get SerialNumber");
        BufferedReader diskStreamReader = new BufferedReader(new InputStreamReader(diskProcessHandle.getInputStream()));
        diskStreamReader.readLine();
        String serialNumber = diskStreamReader.readLine().trim();
        diskStreamReader.close();

        // 获取 BIOS 序列号
        Process biosProcessHandle = Runtime.getRuntime().exec("wmic bios get SerialNumber");
        BufferedReader biosStreamReader = new BufferedReader(new InputStreamReader(biosProcessHandle.getInputStream()));
        biosStreamReader.readLine();
        String biosSerialNumber = biosStreamReader.readLine().trim();
        biosStreamReader.close();

        // 拼接硬件信息
        String hardwareInfo = cpuId + serialNumber + biosSerialNumber;
        // 计算摘要
        MessageDigest digest = MessageDigest.getInstance(DIGEST_ALGORITHM_NAME);
        byte[] digestBytes = digest.digest(hardwareInfo.getBytes(StandardCharsets.UTF_8));
        // 转换为十六进制字符串
        StringBuilder hexStringBuilder = new StringBuilder();
        for (byte byteValue : digestBytes) {
            String hex = Integer.toHexString(0xff & byteValue);
            if (hex.length() == 1) {
                hexStringBuilder.append('0');
            }
            hexStringBuilder.append(hex);
        }
        String hashedHardwareInfo = hexStringBuilder.toString();
        if (hashedHardwareInfo.length() > 40) {
            hashedHardwareInfo = hashedHardwareInfo.substring(0, 40);
        } else if (hashedHardwareInfo.length() < 40) {
            hashedHardwareInfo = String.format("%-40s", hashedHardwareInfo).replace(' ', '0');
        }

        // 获取加密密钥
        String encryptionKey = hashedHardwareInfo.substring(0, 8);
        // 获取明文
        String plaintext = hashedHardwareInfo.substring(8);
        // 计算密钥摘要
        MessageDigest keyDigest = MessageDigest.getInstance(DIGEST_ALGORITHM_NAME);
        byte[] keyDigestBytes = keyDigest.digest(encryptionKey.getBytes(StandardCharsets.UTF_8));
        byte[] encryptionKeyBytes = Arrays.copyOf(keyDigestBytes, 16);
        // 生成密钥规范
        SecretKeySpec encryptionKeySpec = new SecretKeySpec(encryptionKeyBytes, ALGORITHM_NAME);
        // 获取加密器
        Cipher encryptionCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        encryptionCipher.init(Cipher.ENCRYPT_MODE, encryptionKeySpec);
        // 加密
        byte[] ciphertext = encryptionCipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));
        String base64EncodedCiphertext = Base64.getEncoder().encodeToString(ciphertext);
        String base64EncodedCiphertextSubstring = base64EncodedCiphertext.replaceAll("[^A-Z0-9]", "").substring(0, 16);

        // 获取解密密钥
        byte[] decryptionKeyBytes = Arrays.copyOf(MessageDigest.getInstance(DIGEST_ALGORITHM_NAME).digest(base64EncodedCiphertextSubstring.getBytes(StandardCharsets.UTF_8)), KEY_LENGTH_BITS / 8);
        // 生成密钥规范
        SecretKeySpec decryptionKeySpec = new SecretKeySpec(decryptionKeyBytes, ALGORITHM_NAME);
        // 获取解密器
        Cipher decryptionCipher = Cipher.getInstance(ALGORITHM_NAME);
        decryptionCipher.init(Cipher.ENCRYPT_MODE, decryptionKeySpec);
        // 解密
        byte[] decryptedPlaintextBytes = decryptionCipher.doFinal(base64EncodedCiphertextSubstring.getBytes(StandardCharsets.UTF_8));
        String base64EncodedDecryptedPlaintext = Base64.getEncoder().encodeToString(decryptedPlaintextBytes);

        // 替换字符
        StringBuilder encryptedPlaintext3Builder = new StringBuilder();
        for (int i = 0; i < BLOCK_SIZE_BYTES; i++) {
            char c = base64EncodedDecryptedPlaintext.charAt(i);
            if (c == '+') {
                encryptedPlaintext3Builder.append('A');
            } else if (c == '/') {
                encryptedPlaintext3Builder.append('B');
            } else if (c == '=') {
                encryptedPlaintext3Builder.append('C');
            } else {
                encryptedPlaintext3Builder.append(Character.toUpperCase(c));
            }
        }
        String encryptedPlaintext = encryptedPlaintext3Builder.toString();

        // 获取 HMAC 密钥
        String hmacKey = encryptedPlaintext.substring(0, 8);
        // 获取 HMAC 消息
        String hmacMessage = encryptedPlaintext.substring(8);
        // 计算 HMAC 密钥摘要
        MessageDigest hmacKeyDigest = MessageDigest.getInstance(DIGEST_ALGORITHM_NAME);
        byte[] hmacKeyBytes = hmacKeyDigest.digest(key.getBytes(StandardCharsets.UTF_8));
        // 生成 HMAC 密钥规范
        SecretKeySpec hmacKeySpec = new SecretKeySpec(hmacKeyBytes, "HmacSHA256");
        // 获取 HMAC
        Mac hmac = Mac.getInstance("HmacSHA256");
        hmac.init(hmacKeySpec);
        // 计算 HMAC
        byte[] hmacDigestBytes = hmac.doFinal(hmacMessage.getBytes(StandardCharsets.UTF_8));
        String base64EncodedHmacDigest = Base64.getEncoder().encodeToString(hmacDigestBytes);
        return base64EncodedHmacDigest.replaceAll("[^A-Za-z0-9]", "").toUpperCase().substring(0, 16);
    }
}