package com.uaian.aws.lambda.processor.excel.parse;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.uaian.aws.utils.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;


@Slf4j
public class ExcelParseS3TriggerProcessor implements RequestHandler<Map<String, Object>, String> {

    private final AmazonS3 s3Client = AmazonS3Client.builder()
            .withRegion(Regions.US_EAST_2)  // Ensure this is the correct region
            .build();;

    @Override
    public String handleRequest(Map<String, Object> event, Context context) {
        // 从事件中获取S3记录
        List<Map<String, Object>> records = (List<Map<String, Object>>) event.get("Records");
        Map<String, Object> s3Event = (Map<String, Object>) records.get(0).get("s3");
        Map<String, Object> bucket = (Map<String, Object>) s3Event.get("bucket");
        Map<String, Object> object = (Map<String, Object>) s3Event.get("object");

        // 获取桶名和对象键
        String bucketName = (String) bucket.get("name");
        String objectKey = (String) object.get("key");

        try (S3Object s3Object = s3Client.getObject(bucketName, objectKey);
             InputStream inputStream = s3Object.getObjectContent();
             Workbook workbook = new XSSFWorkbook(inputStream)) {

            // 处理Excel数据
            Sheet sheet = workbook.getSheetAt(0);
            // ... 在这里添加你的Excel处理逻辑


            return "Successfully processed " + objectKey + " from bucket " + bucketName;
        } catch (IOException e) {
            return "Error processing " + objectKey + " from bucket " + bucketName + ": " + e.getMessage();
        }
    }
}
