package com.hrms.karcan;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.hrms.karcan.business.adapters.cloudinary.CloudinaryConfiguration;
import com.hrms.karcan.core.dataAccess.concretes.BaseRepositoryImpl;

@Configuration
@EnableConfigurationProperties(value = {CloudinaryConfiguration.class})
@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class)
public class KarcanConfiguration {

}
