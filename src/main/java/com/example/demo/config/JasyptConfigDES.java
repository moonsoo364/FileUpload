package com.example.demo.config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableEncryptableProperties
@Slf4j
public class JasyptConfigDES {

	@Bean("jasyptEncryptor")
	public StringEncryptor stringEncryptor() {
		PooledPBEStringEncryptor encyptor = new PooledPBEStringEncryptor();
		SimpleStringPBEConfig config = new SimpleStringPBEConfig();
		config.setPassword(this.getJasyptEncryptPassword());
		config.setAlgorithm("PBEWithMD5AndDES");
		config.setKeyObtentionIterations(1000);
		config.setPoolSize(2);
		config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
		config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
		config.setStringOutputType("base64");
		encyptor.setConfig(config);
		return encyptor;
	}
	private String getJasyptEncryptPassword() {
		
			ClassPathResource resource = new ClassPathResource("jasypt/jasypt-encryptor-password.txt");
			try {
				String result = Files.readAllLines(Paths.get(resource.getURI())).stream().collect(Collectors.joining());
				return result;
			} catch (IOException e) {
				throw new RuntimeException("Not Found jasypt password file");
			}
			
	
		
		
	}
}

