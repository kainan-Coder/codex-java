package com.uaian.aws.lambda.processor.glue;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import software.amazon.awssdk.services.glue.GlueClient;
import software.amazon.awssdk.services.glue.model.*;
import software.amazon.awssdk.regions.Region;

import java.util.Map;

public class GlueCrawlerCreator implements RequestHandler<Map<String, String>, String> {

    private final GlueClient glueClient = GlueClient.builder()
            .region(Region.US_WEST_2)  // Change this to your desired region
            .build();

    @Override
    public String handleRequest(Map<String, String> input, Context context) {
        String crawlerName = input.get("crawlerName");
        String databaseName = input.get("databaseName");
        String s3TargetPath = input.get("s3TargetPath");
        String iamRole = input.get("iamRole");

        try {
            // Create the crawler
            createCrawler(crawlerName, databaseName, s3TargetPath, iamRole);

            // Start the crawler
            startCrawler(crawlerName);

            return "Successfully created and started crawler: " + crawlerName;
        } catch (Exception e) {
            context.getLogger().log("Error: " + e.getMessage());
            return "Error creating or starting crawler: " + e.getMessage();
        }
    }

    private void createCrawler(String crawlerName, String databaseName, String s3TargetPath, String iamRole) {
        S3Target s3Target = S3Target.builder()
                .path(s3TargetPath)
                .build();

        CreateCrawlerRequest crawlerRequest = CreateCrawlerRequest.builder()
                .name(crawlerName)
                .role(iamRole)
                .databaseName(databaseName)
                .targets(CrawlerTargets.builder().s3Targets(s3Target).build())
                .build();

        glueClient.createCrawler(crawlerRequest);
    }

    private void startCrawler(String crawlerName) {
        StartCrawlerRequest startCrawlerRequest = StartCrawlerRequest.builder()
                .name(crawlerName)
                .build();

        glueClient.startCrawler(startCrawlerRequest);
    }
}
