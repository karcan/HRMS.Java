package outsource.com.cloudinary;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.cloudinary.json.JSONObject;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;


public class CloudinaryManager {
	private Cloudinary cloudinary;
	
	public CloudinaryManager(CloudinaryConfiguration cloudinaryConfiguration) {
		cloudinary = new Cloudinary(cloudinaryConfiguration.toString());
	}


	public JSONObject upload(File file) {
		try {
			@SuppressWarnings("unchecked")
			Map<String, Object> uploadResult = this.cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
			JSONObject response=new JSONObject(uploadResult);
			return response;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	} 
	
}
