package com.example.demo.file.dao;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.demo.file.dto.FileType;
import com.example.demo.file.dto.UploadFileDto;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class FileDao {
	
	@Value("${file.default}")
	private String defaultDir;
	
	@Value("${file.text}")
	private String textDir;
	
	@Value("${file.image}")
	private String imageDir;
	
	@Value("${file.video}")
	private String videoDir;
	
	
	public String getDirectory(FileType fileType) {
		switch(fileType) {
		case TEXT: return this.textDir;
		case IMAGE: return this.imageDir;
		case VIDEO: return this.videoDir;
		default: return "Not Found";
		}
	}

	public void uploadFile(UploadFileDto param) {
		String path = this.getDirectory(param.getFileType());
		this.mkDir(new File(this.defaultDir));
		this.mkDir(new File(path));
		String sb = new StringBuilder().append(path).append(param.getUploadFile().getOriginalFilename()).toString();
		log.info(sb);
		File targerFile = new File(sb);
			try {
				param.getUploadFile().transferTo(targerFile);
			} catch (IllegalStateException | IOException e) {
				log.info(e.toString());
			}
	}
	private void mkDir(File dir) {
		boolean isDirExists = dir.exists();
		if(!isDirExists) {
			dir.mkdir();
		}
		
	}
}
