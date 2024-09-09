package com.uaian.aws.lambda.processor.excel.parse.reader;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.IOException;
import java.io.InputStream;

public class XlsFileReader implements FileReaderStrategy {
    @Override
    public void read(InputStream inputStream) throws IOException {
        try (Workbook workbook = new HSSFWorkbook(inputStream)) {
            System.out.println("Reading XLS file...");
            // 实际读取逻辑...
            // Example: Print sheet names
            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                System.out.println("Sheet: " + workbook.getSheetName(i));
            }
        }
    }
}
