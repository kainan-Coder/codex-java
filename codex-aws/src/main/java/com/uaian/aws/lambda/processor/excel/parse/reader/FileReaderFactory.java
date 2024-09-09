package com.uaian.aws.lambda.processor.excel.parse.reader;

public class FileReaderFactory {
    public static FileReaderStrategy getFileReaderStrategy(String fileExtension) {
        switch (fileExtension.toLowerCase()) {
            case "xlsx":
                return new XlsxFileReader();
            case "xls":
                return new XlsFileReader();
            case "csv":
                return new CsvFileReader();
            default:
                throw new IllegalArgumentException("Unsupported file type: " + fileExtension);
        }
    }
}
