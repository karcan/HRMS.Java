package com.hrms.karcan.business.adapters;

import java.io.File;

import org.cloudinary.json.JSONObject;
import org.springframework.stereotype.Service;

import com.hrms.karcan.business.abstracts.UploaderService;
import com.hrms.karcan.core.utilities.result.ErrorResult;
import com.hrms.karcan.core.utilities.result.Result;
import com.hrms.karcan.core.utilities.result.SuccessResult;

import outsources.com.cloudinary.CloudinaryConfiguration;
import outsources.com.cloudinary.CloudinaryManager;

@Service
public class CloudinaryAdapter implements UploaderService {
	private CloudinaryConfiguration cloudinaryConfiguration;
	
	

	public CloudinaryAdapter(CloudinaryConfiguration cloudinaryConfiguration) {
		this.cloudinaryConfiguration = cloudinaryConfiguration;
	}


	@Override
	public Result imageUpload(File file) {
		
		CloudinaryManager cloudinaryManager = new CloudinaryManager(cloudinaryConfiguration);
		JSONObject url = cloudinaryManager.upload(file);
		if(url != null) {
			return new SuccessResult(url.getString("url"));
		}
		
		return new ErrorResult();
	}
	
}
