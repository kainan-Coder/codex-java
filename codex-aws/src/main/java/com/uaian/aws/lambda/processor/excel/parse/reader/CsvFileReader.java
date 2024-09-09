package com.uaian.aws.lambda.processor.excel.parse.reader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.*;


public class CsvFileReader implements FileReaderStrategy {
    @Override
    public void read(InputStream inputStream) throws IOException {
        try {
            // 1. 将 InputStream 写入到一个临时文件
            Path tempFile = Files.createTempFile("temp-csv", ".csv");
            Files.copy(inputStream, tempFile, StandardCopyOption.REPLACE_EXISTING);

            // 2. 使用 H2 Database 读取 CSV 文件
            // 创建内存数据库连接
            Connection conn = DriverManager.getConnection("jdbc:h2:mem:");
            Statement stat = conn.createStatement();

            // 使用 CSVREAD 函数将 CSV 文件内容读取到表中
            String csvFilePath = tempFile.toAbsolutePath().toString().replace("\\", "\\\\");  // 对 Windows 需要双斜杠
            stat.execute("CREATE TABLE users AS SELECT * FROM CSVREAD('" + csvFilePath + "')");

            // 3. 执行 SQL 查询
            ResultSet rs = stat.executeQuery("SELECT * FROM users WHERE age > 26");


            // 4. 将查询结果转换为 JSON（动态获取表头）
            String jsonResult = resultSetToJson(rs);

            // 输出 JSON
            System.out.println(jsonResult);

            // 5. 清理资源
            rs.close();
            stat.close();
            conn.close();
            Files.delete(tempFile);  // 删除临时文件

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String resultSetToJson(ResultSet resultSet) throws Exception {
        // 使用 Jackson ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode arrayNode = mapper.createArrayNode();

        // 获取结果集的元数据
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        // 遍历结果集并转换为 JSON 对象
        while (resultSet.next()) {
            ObjectNode jsonObject = mapper.createObjectNode();
            for (int i = 1; i <= columnCount; i++) {  // 动态获取列名和列值
                String columnName = metaData.getColumnName(i);
                jsonObject.put(columnName, resultSet.getString(i));  // 使用列名作为键，列值作为值
            }
            arrayNode.add(jsonObject);
        }

        // 返回 JSON 字符串
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(arrayNode);
    }
}
