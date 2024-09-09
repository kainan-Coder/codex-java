package com.uaian.aws.lambda.processor.excel.parse.reader;


import java.io.IOException;
import java.io.InputStream;

public interface FileReaderStrategy {
    void read(InputStream inputStream) throws IOException;

}
