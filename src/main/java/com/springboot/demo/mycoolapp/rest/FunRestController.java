package com.springboot.demo.mycoolapp.rest;

import com.springboot.demo.mycoolapp.common.StudentErrorResponse;
import com.springboot.demo.mycoolapp.common.StudentNotFoundException;
import com.springboot.demo.mycoolapp.common.Students;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FunRestController {

    private List<Students> students;

    @PostConstruct
    public void loadData() {
        students = new ArrayList<>();

        students.add(new Students("Johny", "Cash"));
        students.add(new Students("Terry", "Brown"));
        students.add(new Students("Jack", "Black"));
    }


    @GetMapping("/students")
    public List<Students> getStudents() {
        return students;
    }

    @GetMapping("/students/{studentsId}")
    public Students getStudent(@PathVariable int studentsId) {


        if ((studentsId >= students.size()) || studentsId < 0) {
            throw new StudentNotFoundException(("Student id not found: " + studentsId));
        }
        Students student = students.get(studentsId);
        return student;
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exception) {

        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exception.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    ;

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exception) {

        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exception.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
