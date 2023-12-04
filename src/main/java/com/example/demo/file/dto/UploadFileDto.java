package com.example.demo.file.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UploadFileDto {

	private MultipartFile uploadFile;
	private FileType fileType;
}
