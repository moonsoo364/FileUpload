package com.example.demo.file.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.file.dao.FileDao;
import com.example.demo.file.dto.FileType;
import com.example.demo.file.dto.UploadFileDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FileServiceImpl implements FileService{
	@Autowired
	private FileDao fileDao;
	
	
	@Value("${s3.bucket}")
	private String bucket;
	
	@Value("${s3.region}")
	private String region;
	
	@Value("${s3.credentials.accessKey}")
	private String accessKey;
	
	@Value("${s3.credentials.secretKey}")
	private String secretKey;
	
	
	
	
	@Override
	public String getFileDirectory(FileType type) {
		return fileDao.getDirectory(type);
	}


	@Override
	public void uploadFile(UploadFileDto param) {
		fileDao.uploadFile(param);
	}


	@Override
	public void getInfo() {
		log.info(bucket);
		log.info(region);
		log.info(accessKey);
		log.info(secretKey);
		
	}


}
