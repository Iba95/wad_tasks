package com.example.demo.Model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Set;

@Entity(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private String description;
    private Date date;
    private int id_status;
    private int id_reference;
    private int id_contact;
    @ManyToOne(cascade=CascadeType.DETACH)
    @JoinColumn(name = "id_status", updatable = false,insertable = false)
    private Status status;

    @ManyToOne(cascade=CascadeType.DETACH)
    @JoinColumn(name = "id_reference", updatable = false,insertable = false)
    private Reference reference;
    @ManyToOne(cascade=CascadeType.DETACH)
    @JoinColumn(name = "id_contact", updatable = false,insertable = false)
    private Contact contact;

    public Task(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId_status() {
        return id_status;
    }

    public void setId_status(int id_status) {
        this.id_status = id_status;
    }

    public int getId_reference() {
        return id_reference;
    }

    public void setId_reference(int id_reference) {
        this.id_reference = id_reference;
    }

    public int getId_contact() {
        return id_contact;
    }

    public void setId_contact(int id_contact) {
        this.id_contact = id_contact;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Reference getReference() {
        return reference;
    }

    public void setReference(Reference reference) {
        this.reference = reference;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
