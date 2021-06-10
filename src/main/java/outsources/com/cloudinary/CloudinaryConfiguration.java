package outsources.com.cloudinary;

import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Component
@ConfigurationProperties(prefix = "cloudinary")
@Getter
@Setter
@Validated
public class CloudinaryConfiguration {
	@NotNull
	private String apiKey;
	@NotNull
	private String secret;
	@NotNull
	private String cloudName;
	
	public String toString() {
		return "cloudinary://"+this.getApiKey()+":"+this.getSecret()+"@"+this.getCloudName();
	}
}
