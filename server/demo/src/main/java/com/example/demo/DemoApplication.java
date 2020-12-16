package com.example.demo;

import com.example.demo.Controller.TaskDataController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		TaskDataController controller = new TaskDataController();
	}

}
