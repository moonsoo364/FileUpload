package com.example.demo.file.service;

import com.example.demo.file.dto.FileType;
import com.example.demo.file.dto.UploadFileDto;

public interface FileService {
	
	String getFileDirectory(FileType type);
	
	void getInfo();

	void uploadFile(UploadFileDto param);

}
	