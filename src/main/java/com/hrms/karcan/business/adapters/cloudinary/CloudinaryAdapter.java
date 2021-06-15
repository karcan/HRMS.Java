package com.hrms.karcan.business.adapters.cloudinary;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import org.cloudinary.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudinary.Cloudinary;
import com.cloudinary.EagerTransformation;
import com.cloudinary.utils.ObjectUtils;
import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.core.utilities.result.ErrorDataResult;
import com.hrms.karcan.core.utilities.result.MediaResult;
import com.hrms.karcan.core.utilities.result.SuccessDataResult;


@Service
public class CloudinaryAdapter {
	private Cloudinary cloudinary;
	
	@Autowired
	public CloudinaryAdapter(CloudinaryConfiguration cloudinaryConfiguration) {
		cloudinary = new Cloudinary(cloudinaryConfiguration.toString());
	}


	public DataResult<JSONObject> imageUpload(File file) {
		try {
			
			Map<String, Object> uploadResult = this.cloudinary.uploader().upload(file, ObjectUtils.asMap("eager", Arrays.asList(
					new EagerTransformation().width(150).height(150).crop("scale")
					)));
			JSONObject response = new JSONObject(uploadResult);
			return new SuccessDataResult<>(response);
			
		} catch (IOException e) {
			
			e.printStackTrace();
			return new ErrorDataResult<>(e.getMessage(), null);
			
		}
		
	} 
	
}
