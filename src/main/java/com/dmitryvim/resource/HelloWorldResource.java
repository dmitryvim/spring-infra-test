package com.dmitryvim.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldResource {

    @GetMapping("/hey")
    public String hey(@RequestParam(value = "name", required = false) String name) {
        return name == null ? "Hey noname" : ("Glad to meet you " + name);
    }
}
