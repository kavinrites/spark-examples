package org.example;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.SparkSession;

/**
 * Hello world!
 *
 */
public class MySparkSession
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SparkSession sparkSession = SparkSession
                .builder()
                .appName("Simple Spark Application")
                .config("spark.master","local")
                .getOrCreate();
        Dataset<String> stringDataset = sparkSession.read().textFile("pom.xml").cache();
        long numAs = stringDataset.count();
        System.out.println(numAs + " lines");
        sparkSession.stop();
    }
}
