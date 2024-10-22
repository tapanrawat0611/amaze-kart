package com.example.demo.service;

import java.io.IOException;
import java.util.List;

import com.amazonaws.services.s3.model.Bucket;

public interface BucketService {

    // get list of buckets for given user
    List<Bucket> getBucketList();

    // check if given bucket name valid
    boolean validateBucket(String bucketName);

    // download given objectName from the bucket
    void getObjectFromBucket(String bucketName, String objectName) throws IOException;

    // upload given file as objectName to S3 bucket
    void putObjectIntoBucket(String bucketName, String objectName, String filePathToUpload);

    // create Bucket with provided name (throws exception if bucket already present)
    void createBucket(String bucket);
}
