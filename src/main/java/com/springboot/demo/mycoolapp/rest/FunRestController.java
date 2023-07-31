package com.springboot.demo.mycoolapp.rest;

import com.springboot.demo.mycoolapp.common.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FunRestController {


    @GetMapping("/students")
    public List<Students> getDailyWorkout() {
        List<Students> students = new ArrayList<>();

        students.add(new Students("Johny","Cash"));
        students.add(new Students("Terry","Brown"));
        students.add(new Students("Jack","Black"));
        return students;
    }
}
