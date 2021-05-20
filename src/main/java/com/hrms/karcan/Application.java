package com.hrms.karcan;

import com.hrms.karcan.entity.concretes.JobTitle;
import com.hrms.outsources.mernis.KPSPublicSoap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

}
