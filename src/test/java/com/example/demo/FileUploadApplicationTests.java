package com.example.demo;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.iv.RandomIvGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class FileUploadApplicationTests {
	@Value("${s3.credentials.accessKey}")
	private String accessKey;
	@Value("${s3.credentials.secretKey}")
	private String secretKey;
	@Value("${s3.region}")
	private String region;
	@Value("${s3.bucket}")
	private String bucket;
	@Autowired
	@Qualifier("jasyptEncryptor")
	private StringEncryptor encryptor;


	@Test
	void contextLoads() {
		this.decrypt(this.encypt(bucket));
		this.decrypt(this.encypt(region));
		this.decrypt(this.encypt(accessKey));
		this.decrypt(this.encypt(secretKey));
	}

	public String encypt(String value) {
		String result = this.encryptor.encrypt(value);
		this.insertLog(result);
		return result;
	}
	public String decrypt(String value) {
		String result = this.encryptor.decrypt(value);
		this.insertLog(result);
		return result;
	}
	public void insertLog(String value) {
		log.info("value: {}",value);
	}

}
