package com.example.demo;

import com.example.demo.Model.Contact;
import com.example.demo.Model.Reference;
import com.example.demo.Model.Status;
import com.example.demo.Model.Task;
import com.example.demo.Repository.ContactRepository;
import com.example.demo.Repository.ReferenceRepository;
import com.example.demo.Repository.StatusRepository;
import com.example.demo.Repository.TasksRepository;
import com.example.demo.Service.TaskDataService;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.sql.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTests {

	@Autowired
	TasksRepository tasksRepository;
	@Autowired
	ContactRepository contactRepository;
	@Test
	void findTask() {

		Optional<Task> found = tasksRepository.findById(3);
			assertThat(found.isPresent()).isEqualTo(true);

	}
	@Test
	void updateTask() {

		Optional<Task> found = tasksRepository.findById(3);
		Task t = found.get();
		t.setTitle("taskTitle changed");
		assertThat(tasksRepository.save(t).getTitle()).isEqualTo(t.getTitle());

	}
	@Test
	void findTaskbyName() {

		Task found = tasksRepository.findByTitle("task4");
		assertThat(found.getTitle()).isEqualTo("task4");

	}
	@Test
	void findContactByEmail() {

		Contact found = contactRepository.findByEmail("contact2@example.com");
		assertThat(found.getEmail()).isEqualTo("contact2@example.com");

	}


}
