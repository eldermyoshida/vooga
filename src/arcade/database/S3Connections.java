package arcade.database;
/*
 * Copyright 2010-2013 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.UUID;
import util.Pixmap;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectSummary;

/**
 * This sample demonstrates how to make basic requests to Amazon S3 using
 * the AWS SDK for Java.
 * <p>
 * <b>Prerequisites:</b> You must have a valid Amazon Web Services developer
 * account, and be signed up to use Amazon S3. For more information on
 * Amazon S3, see http://aws.amazon.com/s3.
 * <p>
 * <b>Important:</b> Be sure to fill in your AWS access credentials in the
 *                   AwsCredentials.properties file before you try to run this
 *                   sample.
 * http://aws.amazon.com/security-credentials
 */
public class S3Connections {
    
    private static final String BUCKET_NAME = "mycs308database";  
    private static final String S3_FolderKey_PlayerPhotos = "photos/";


    private AmazonS3 myS3Instance;
    
    public S3Connections() {
        myS3Instance = new AmazonS3Client(new ClasspathPropertiesFileCredentialsProvider("AwsCredentials.properties"));
        Region usWest2 = Region.getRegion(Regions.US_WEST_2);
        myS3Instance.setRegion(usWest2);
    }
    
    public void listAllBuckets() {
        System.out.println("Listing buckets");
        for (Bucket bucket : myS3Instance.listBuckets()) {
            System.out.println(" - " + bucket.getName());
        }
    }
    
    public void putAvatarIntoBucket(String username, String filepath) {
        putObjectIntoBucket("avatar" + username, filepath);
    }
    
    public void putGameThumbnailIntoBucket(String gameName, String filepath) {
        putObjectIntoBucket("thumbnail" + gameName, filepath);
    }
    
    public void getAvatar(String username) {
        downloadObjectImage("avatar" + username);
    }
    
    public void putObjectIntoBucket(String key, String filepath) {
        File file = new File(filepath);
        try {
            myS3Instance.putObject(new PutObjectRequest(BUCKET_NAME, key, file));
        }
        catch (AmazonServiceException ase) {
            System.out.println("Caught an AmazonServiceException, which means your request made it "
                    + "to Amazon S3, but was rejected with an error response for some reason.");
            System.out.println("Error Message:    " + ase.getMessage());
            System.out.println("HTTP Status Code: " + ase.getStatusCode());
            System.out.println("AWS Error Code:   " + ase.getErrorCode());
            System.out.println("Error Type:       " + ase.getErrorType());
            System.out.println("Request ID:       " + ase.getRequestId());
        }
        catch (AmazonClientException ace) {
            System.out.println("Caught an AmazonClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with S3, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message: " + ace.getMessage());        
        }
    }
    
    public void downloadObjectImage(String key) {
        File file = new File("/Users/nataliacarvalho/Desktop/testing4.png");
        ObjectMetadata object = myS3Instance.getObject(new GetObjectRequest(BUCKET_NAME, key), file);
    }
    
    public void deleteObject(String key) {
      myS3Instance.deleteObject(BUCKET_NAME, key);
    }
}
