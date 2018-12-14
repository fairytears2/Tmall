package com.netease.course.uitls;

import org.springframework.web.multipart.MultipartFile;

public class UploadedImageFile {
		MultipartFile image;
	 
	    public MultipartFile getImage() {
	        return image;
	    }
	 
	    public void setImage(MultipartFile image) {
	        this.image = image;
	    }
	 
}
