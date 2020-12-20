package com.example.demo.Model;
import javax.persistence.*;
import java.util.Set;

@Entity(name = "status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String status;

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    @OneToMany(mappedBy = "status", fetch = FetchType.LAZY)
    private Set<Task> tasks;

    public Status() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
