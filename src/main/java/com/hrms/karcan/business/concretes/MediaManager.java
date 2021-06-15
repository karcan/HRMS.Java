package com.hrms.karcan.business.concretes;

import java.awt.print.Printable;
import java.io.File;

import org.cloudinary.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.karcan.business.abstracts.MediaService;
import com.hrms.karcan.business.adapters.cloudinary.CloudinaryAdapter;
import com.hrms.karcan.core.utilities.result.DataResult;
import com.hrms.karcan.core.utilities.result.ErrorDataResult;
import com.hrms.karcan.core.utilities.result.MediaResult;
import com.hrms.karcan.core.utilities.result.SuccessDataResult;

@Service
public class MediaManager implements MediaService {
	
	private CloudinaryAdapter cloudinaryAdapter;
	
	@Autowired
	public MediaManager(CloudinaryAdapter cloudinaryAdapter) {
		this.cloudinaryAdapter = cloudinaryAdapter;
	}



	@Override
	public DataResult<MediaResult> setImage(File file) {
		return this.cloudinarySetImage(file);
	}
	
	
	private DataResult<MediaResult> cloudinarySetImage(File file) {
		DataResult<JSONObject> result = this.cloudinaryAdapter.imageUpload(file);
		JSONObject eagerJsonObject = result.getData().getJSONArray("eager").getJSONObject(0);
		MediaResult mediaResult = new MediaResult(eagerJsonObject.getString("url"), result.getData().getString("public_id"));		
		if(!result.isSuccess()) {
			return new ErrorDataResult<MediaResult>(result.getMessage(), null);
		}
		
		return new SuccessDataResult<MediaResult>(result.getMessage(), mediaResult);
	}

}
