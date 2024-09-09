package com.uaian.aws.lambda.processor.excel.parse.reader;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;

public class XlsxFileReader implements FileReaderStrategy {
    @Override
    public void read(InputStream inputStream) throws IOException {
        try (Workbook workbook = new XSSFWorkbook(inputStream)) {
            System.out.println("Reading XLSX file...");
            // 实际读取逻辑...
            // Example: Print sheet names
            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                System.out.println("Sheet: " + workbook.getSheetName(i));
            }
        }
    }
}
