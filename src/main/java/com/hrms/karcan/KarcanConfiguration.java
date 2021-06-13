package com.hrms.karcan;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;


import outsource.com.cloudinary.CloudinaryConfiguration;

@Configuration
@EnableConfigurationProperties(value = {CloudinaryConfiguration.class})
public class KarcanConfiguration {

}
