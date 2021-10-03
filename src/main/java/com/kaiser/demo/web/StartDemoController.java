package com.kaiser.demo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StartDemoController {

    @GetMapping(value = "/starter/{name}")
    public void startDemo(@PathVariable(value = "name")String name){
        System.out.println(name+", this is your first springboot demo!");
    }
}
