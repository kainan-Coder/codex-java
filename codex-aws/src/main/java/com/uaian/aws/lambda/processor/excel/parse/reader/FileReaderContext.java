package com.uaian.aws.lambda.processor.excel.parse.reader;


import java.io.IOException;
import java.io.InputStream;

public class FileReaderContext {

    private FileReaderStrategy strategy;

    public void setStrategy(FileReaderStrategy strategy) {
        this.strategy = strategy;
    }

    public void readFile(InputStream inputStream) throws IOException{
        if (strategy == null) {
            throw new IllegalStateException("Strategy not set");
        }
        strategy.read(inputStream);
    }
}
