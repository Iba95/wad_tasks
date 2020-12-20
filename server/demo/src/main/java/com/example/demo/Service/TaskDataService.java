package com.example.demo.Service;

import com.example.demo.Model.Contact;
import com.example.demo.Model.Reference;
import com.example.demo.Model.Status;
import com.example.demo.Model.Task;
import com.example.demo.Repository.ContactRepository;
import com.example.demo.Repository.ReferenceRepository;
import com.example.demo.Repository.StatusRepository;
import com.example.demo.Repository.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TaskDataService {

    @Autowired
    private TasksRepository tasksRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ReferenceRepository referenceRepository;

    public List<Task> getAllTasks() {
        return (List<Task>) tasksRepository.findAll();
    }
    public Optional<Status> getStatus(String id) {
        return statusRepository.findById(Integer.parseInt(id));
    }

    public Task addTask(Task task) {

        // save contact if not exist
        String email = task.getContact().getEmail();
        Contact contact = contactRepository.findByEmail(email);

        if(contact !=null){

            // contact already exists in database
            task.setContact(contact);

        }else {

            //if not needs to be created
            contact.setEmail(email);
            contactRepository.save(contact);
            Contact c = contactRepository.findByEmail(email);
            task.setContact(contactRepository.findByEmail(email));
            task.setId_contact(c.getId());

        }

        //save reference if not exist
        String url = task.getReference().getUrl();
        Reference reference = referenceRepository.findByUrl(url);

        if(reference != null){

            // reference already exists in database
            task.setReference(reference);
        }else {

            //reference needs to be created
            reference.setType(task.getReference().getType());
            reference.setUrl(url);
            reference.setId(1 + (int)(Math.random() * ((240 - 1) + 1)));
            referenceRepository.save(reference);
            task.setReference(referenceRepository.findByUrl(url));
        }

        //get status id
        String _status = task.getStatus().getStatus();
        Status status = statusRepository.findByStatus(_status);
        int s_id = status.getId();
        task.setStatus(status);
        task.setId_status(s_id);
        task.setId(1 + (int)(Math.random() * ((240 - 1) + 1)));

        //save task in database
       return tasksRepository.save(task);

    }

    public Task updateTask(Task task) {

        contactRepository.save(task.getContact());
        referenceRepository.save(task.getReference());
        statusRepository.save(task.getStatus());
        return tasksRepository.save(task);
    }

    public List<Task> deleteTask(Integer id) {
        tasksRepository.deleteById(id);
        return (List<Task>) tasksRepository.findAll();
    }
}
