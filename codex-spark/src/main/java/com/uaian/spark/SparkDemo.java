package com.uaian.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class SparkDemo {

    public static SparkSession initializeSpark() {

        System.setProperty("hadoop.home.dir", "D:\\hadoop-3.0.0");

        SparkConf conf = new SparkConf()
                .setAppName("RemoteSparkExample")
                .setMaster("spark://10.189.255.165:7077")
                .set("spark.driver.host", "10.196.90.128")
                .set("spark.driver.bindAddress", "0.0.0.0")
                .set("spark.network.timeout", "600s")
                .set("spark.executor.heartbeatInterval", "120s")
                .set("spark.rpc.askTimeout", "300s")
                .set("spark.rpc.lookupTimeout", "300s")
                .set("spark.ui.enabled", "false")  // Disable Spark UI to avoid potential issues
                .set("spark.metrics.conf.*.source.jvm.class", "org.apache.spark.metrics.source.JvmSource")
                .set("spark.executor.memory", "500m")
                .set("spark.executor.cores", "1")
                .set("spark.cores.max", "1")
//                .set("spark.metrics.conf", "metrics.properties")  // Use custom metrics configuration
                .set("spark.metrics.staticSources.enabled", "false");  // Disable static sources

        try {

            return SparkSession.builder()
                    .config(conf)
                    .getOrCreate();
        } catch (Exception e) {
            System.err.println("Error initializing Spark: " + e.getMessage());
            e.printStackTrace();
            // 根据你的需求，你可能想要抛出异常或返回null
            return null;
        }
    }

    public static void main(String[] args) {

        SparkSession spark = initializeSpark();
        if (spark != null) {

            // 简单的 Spark 操作
            Dataset<Row> df = spark.range(1, 1000000).toDF("number");
            long count = df.filter(df.col("number").mod(2).equalTo(0)).count();

            System.out.println("Number of even numbers: " + count);
            spark.stop();
        } else {
            System.err.println("Failed to initialize Spark. Exiting.");
            System.exit(1);
        }
    }
}