package com.example.demo.Service;

import com.example.demo.Model.Student;
import java.util.ArrayList;

//Die Service Klasse kennt die Studenten und kann operationen auf
//einer Liste von Studenten durchführen.
public class StudentService {

    private ArrayList<Student> students;

    //Hier wird einfach mal eine Liste angelegt
    //damit wir Daten zur Veranschaulichung haben
    //später würde man über einen Gateway Daten laden.
    public StudentService(){
        students = new ArrayList<>();
        students.add(new Student(1, "Franz", "Mayer"));
        students.add(new Student(2, "Karin", "Müller"));
        students.add(new Student(3, "Sabrina", "Moser"));

    }

    //getter der gesamtem liste
    public ArrayList<Student> getStudents() {
        return students;
    }

    //hier suchen wir einen Studenten per ID
    public Student getStudentById(int id){

        for(Student student : students){
            if(student.getId() == id ){
                return student;
            }
        }

        //bad fallback
        return students.get(0);
    }

}
