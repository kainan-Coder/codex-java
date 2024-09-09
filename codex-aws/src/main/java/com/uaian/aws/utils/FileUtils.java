package com.uaian.aws.utils;

import java.nio.file.Paths;

public class FileUtils {

    // 获取文件扩展名的方法
    public static String getFileExtension(String objectKey) {
        // 使用 Paths 获取文件名， 然后提取扩展名
        String fileName = Paths.get(objectKey).getFileName().toString();
        int lastIndexOfDot = fileName.lastIndexOf(".");
        if (lastIndexOfDot == -1) {
            return ""; // 如果没有找到扩展名，返回空字符串
        }
        return fileName.substring(lastIndexOfDot + 1);
    }
}
