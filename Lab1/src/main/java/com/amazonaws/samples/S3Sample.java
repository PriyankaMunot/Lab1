package com.amazonaws.samples;
import java.io.File;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.profile.internal.AwsProfileNameLoader;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.util.StringUtils;

/**
 * This sample demonstrates how to make basic requests to Amazon S3 using the
 * AWS SDK for Java.
 * <p>
 * <b>Prerequisites:</b> You must have a valid Amazon Web Services developer
 * account, and be signed up to use Amazon S3. For more information on Amazon
 * S3, see http://aws.amazon.com/s3.
 * <p>
 * Fill in your AWS access credentials in the provided credentials file
 * template, and be sure to move the file to the default location
 * (C:\\Users\\P7111957\\.aws\\credentials) where the sample code will load the credentials from.
 * <p>
 * <b>WARNING:</b> To avoid accidental leakage of your credentials, DO NOT keep
 * the credentials file in your source directory.
 *
 * http://aws.amazon.com/security-credentials
 */
public class S3Sample {


    	public static void main(String[] args){
            String bucketName = "my-img-bucket-lab1";

            try {
            	
            	
            	AWSCredentials credentials = new BasicAWSCredentials("AKIAWEMT6X5RWM64DTTP", "BC0D4TqolAZJyEK4uDZcKOFiTwrIXU//uRDUOGbv");
        		//AmazonS3 s3Client = new AmazonS3Client(credentials);
            	
            	//AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
            	AmazonS3 s3Client = AmazonS3ClientBuilder.standard() .withCredentials(new AWSStaticCredentialsProvider(credentials)) .withRegion(Regions.US_EAST_1) .build();
        		
        		/*AmazonS3 s3Client = AmazonS3ClientBuilder
        				  .standard()
        				  .withCredentials(new AWSStaticCredentialsProvider(credentials))
        				  .withRegion(Regions.US_EAST_1)
        				  .build();*/

                s3Client.putObject(bucketName, "imgUpload/Google.png", new File("D:/aws/Lab1/Google.png"));
            } catch (AmazonServiceException e) {
                e.printStackTrace();
            } catch (SdkClientException e) {
                e.printStackTrace();
            }
        }

}
