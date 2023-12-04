package com.example.demo.file.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.file.dao.FileDao;
import com.example.demo.file.dto.FileType;
import com.example.demo.file.dto.UploadFileDto;

@Service
public class FileServiceImpl implements FileService{
	@Autowired
	FileDao fileDao;
	

	@Override
	public String getFileDirectory(FileType type) {
		return fileDao.getDirectory(type);
	}


	@Override
	public void uploadFile(UploadFileDto param) {
		fileDao.uploadFile(param);
	}


}
