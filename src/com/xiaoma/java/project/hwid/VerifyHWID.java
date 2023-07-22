package com.xiaoma.java.project.hwid;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.Scanner;

public class VerifyHWID {
    public static void main(String[] args) throws Exception {
        System.out.println(HWIDChecker(com.xiaoma.java.project.hwid.GenerateHWID.getEncryptedHardwareId("secret114514"), "TheXiaoma/HWID", "hwid.txt"));
    }

    public static boolean HWIDChecker(String hwid, String repoName, String filePath) throws Exception {
        //String hwid = "FORLGIFL3VEHXYSB";
        //String repoName = "TheXiaoma/HWID";
        //String filePath = "hwid.txt";

        String apiUrl = String.format("https://gitee.com/api/v5/repos/%s/contents/%s", repoName, filePath);
        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        Scanner scanner = new Scanner(conn.getInputStream());
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNext()) {
            sb.append(scanner.next());
        }
        scanner.close();

        String response = sb.toString();
        int contentStart = response.indexOf("\"content\":") + 11; // 找到 content 字段的起始位置
        int contentEnd = response.indexOf("\"", contentStart); // 找到 content 字段的结束位置
        String baseContent = response.substring(contentStart, contentEnd); // 提取 content 字段的值
        byte[] decodedBytes = Base64.getDecoder().decode(baseContent); // 解码为字节数组
        String content = new String(decodedBytes);
        if (content.contains(hwid)) {
            return true;
        } else {
            return false;
        }
    }
}