package com.example.demo.Controller;

import com.example.demo.Service.StudentService;
import com.example.demo.Model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class FirstController {

    //unsere Service Klasse wollen wir in allen Methoden zur Verfügung haben
    //sie kapselt die Arbeit die die Features (public methods) des Controller
    //zur Verfügung stellen
    private StudentService service;

    public FirstController() {
        service = new StudentService();
    }

    //mit Hilfe der Annotation @GetMapping stellt man ganz einfach ein, welcher
    //pfad in der URL zum Aufruf dieser Methode führt
    //Der Rückgabe wert ist tatsächlich eine ArrayList, aber wird von Spring Boot für uns
    //in einen JSON String umgewandelt
    @GetMapping("/list-all")
    public ArrayList listStudents(){
        return service.getStudents();
    }

    //Hier noch ein Beispiel wie Sie ein Pfadvariable übergeben
    @GetMapping("/{id}")
    //und in die Argumentlist übergeben
    public Student getStudentById(@PathVariable int id){

        return service.getStudentById(id);

    }

}
