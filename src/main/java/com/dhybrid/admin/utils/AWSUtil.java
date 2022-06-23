package com.dhybrid.admin.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.Executors;

import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.TransferManagerBuilder;
import com.amazonaws.services.s3.transfer.Upload;

public class AWSUtil {
	public static final String productsFileBucketName = "dhybridproducts";

	public static final String blogsFileBucketName = "dhybridblogs/images";

	public static final String keyName = "";

	public static final String filePath = "";

	static AWSCredentials credentials = new BasicAWSCredentials("AKIAX6E3FGKJXVAEADZD", "q0kcRDK7TRRXDCSfe9zV7N5A0hy4klyVUsozxKOG");

	public static String uploadFileToAWSS3Bucket(String uploadFor, MultipartFile multipartFile) {
		AmazonS3 amazonS3 = AmazonS3ClientBuilder.standard()
				.withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.US_EAST_1).build();

		int maxUploadThreads = 5;

		TransferManager tm = TransferManagerBuilder.standard().withS3Client(amazonS3)
				.withMultipartUploadThreshold((long) (5 * 1024 * 1024))
				.withExecutorFactory(() -> Executors.newFixedThreadPool(maxUploadThreads)).build();

		String bucketName = "";
		if (null != uploadFor && uploadFor.contains("blogs")) {
			bucketName = blogsFileBucketName;
		} else if (null != uploadFor && uploadFor.contains("products")) {
			bucketName = productsFileBucketName;
		}

		File fileToUpload = convert(multipartFile);

		PutObjectRequest request = new PutObjectRequest(bucketName, keyName, fileToUpload);

		Upload upload = tm.upload(request);

		try {
			upload.waitForCompletion();
			fileToUpload.delete();
		} catch (Exception e) {
			System.out.println("Error occurred while uploading file");
			e.printStackTrace();
		}
		return fileToUpload.getName();
	}

	public static File convert(MultipartFile file) {
		File convFile = new File(file.getOriginalFilename()+new Date().getTime());
		try {
			convFile.createNewFile();
			FileOutputStream fos = new FileOutputStream(convFile);
			fos.write(file.getBytes());
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return convFile;
	}
}
