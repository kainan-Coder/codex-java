package com.uaian.aws.lambda.processor.excel.parse.module;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

// 顶级类
@Data
public class ConversionRequest {

    @JsonProperty("dataSources")
    private List<DataSource> dataSources;

    @JsonProperty("outputSink")
    private OutputSink outputSink;

    @JsonProperty("conversionParams")
    private ConversionParams conversionParams;

    // 内部类定义
    @Data
    public static class DataSource {
        private String type;
        private InputSource inputSource;
        private List<ColumnData> columnData;
        private String alias;
        private String standard;
        private int skipColumns;
        private int skipRows;
        private boolean useHeader;
        private String sheetName;
        private int headerRow;
        private List<String> columnsToParse;
    }

    @Data
    public static class InputSource {
        private String bucketName;
        private String objectKey;
        private String type;
        private String dataFormat;
    }

    @Data
    public static class ColumnData {
        private String type;
        private String name;
        private int index;
    }

    @Data
    public static class OutputSink {
        private String dataFormat;
        private String outputType;
    }

    @Data
    public static class ConversionParams {
        private String type;
        private String sqlQuery;
    }
}

