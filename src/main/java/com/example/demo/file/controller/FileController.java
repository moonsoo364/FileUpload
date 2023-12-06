package com.example.demo.file.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.file.dto.FileType;
import com.example.demo.file.dto.UploadFileDto;
import com.example.demo.file.service.FileService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/file")
@Slf4j
public class FileController {

	@Autowired
	private FileService fileService;
	
	
	@PostMapping("/{fileType}")
	public void uploadFile(@RequestPart(name = "file") MultipartFile file, @PathVariable(name = "fileType")FileType fileType) {
		fileService.uploadFile(new UploadFileDto(file,fileType));
	}
	
	@GetMapping("/path")
	public String getPath(@RequestParam(name = "fileType",required = true) FileType fileType) {
		return fileService.getFileDirectory(fileType);
	}
	@GetMapping("/info")
	public void getInfo() {
		fileService.getInfo();
	}
}
