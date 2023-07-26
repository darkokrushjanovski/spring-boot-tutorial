package com.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    // expose "/" that returns "Hello world"


    @GetMapping("/")
    public String sayHello(){
        return "Hello world";
    }

    @GetMapping("test")
    public String testFunction(){
        String a = "test1";
        String b = "test2";
        String c = a.concat(b);

        return c;
    }

}
