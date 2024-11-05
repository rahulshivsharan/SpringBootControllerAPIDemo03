package com.sp;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyMainApplication {
	public static void main(String [] args) {
		SpringApplication myApp = new SpringApplication(MyMainApplication.class);
		//myApp.setDefaultProperties(Collections.singletonMap("server.port", "8089"));
		//myApp.setDefaultProperties(Collections.singletonMap("RAPID_API.KEY", "cb9d056906msh202db15fb23cdf9p1e99c4jsn7dd51c460112"));
		myApp.run(args);
	}
}
