package com.example.demo.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.FileData;
import com.example.demo.repository.StorageRepo;
import com.example.demo.util.ImageUtil;

@Service
public class StorageService {

	@Autowired
	private StorageRepo repo;
	
	public String uploadImage(MultipartFile file)  throws IOException {
		 FileData fileData = repo.save(FileData.builder()
	                .name(file.getOriginalFilename())
	                .type(file.getContentType())
	                .imageData(ImageUtil.compressImage(file.getBytes()))
	                .build());
	        if (fileData != null) {
	            return "file uploaded successfully : " + file.getOriginalFilename();
	        }
	        return null;
	}
	
	 public byte[] downloadImage(String fileName){
	        Optional<FileData> dbImageData = repo.findbyName(fileName);
	        byte[] images=ImageUtil.decompressImage(dbImageData.get().getImageData());
	        return images;
	    }
}
