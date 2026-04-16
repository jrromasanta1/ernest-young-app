package com.ernstyoung.service;

import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.amazonaws.services.s3.AmazonS3;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class MetadataService {

    private final AmazonS3 s3Client;
    private final AtomicInteger processedCount = new AtomicInteger(0);

    public MetadataService(AmazonS3 s3Client) {
        this.s3Client = s3Client;
    }

    @Async
    @Retry(name = "s3Retry", fallbackMethod = "fallback")
    public void processMetadata(String id) {

        // simulate occasional failure
        if (Math.random() < 0.5) {
            System.out.println("Simlulate Fail");
            throw new RuntimeException("fake error simulation SdkClientException");
        }

        //Comment this out if you want to bypass AmazonS3 Connection to test without AWS account/bucket
        s3Client.getObject("my-bucket", id + ".json");

        int count = processedCount.incrementAndGet();
        System.out.println("Processed: " + id + " Total: " + count);
    }

    // fallback after retries exhausted
    public void fallback(String id, Exception ex) {
        System.out.println("Failed after retries: " + id);
    }
}