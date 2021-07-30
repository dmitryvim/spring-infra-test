package com.dmitryvim.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class HelloWorldResource {

    @GetMapping("/hey")
    public HeyResponse hey(@RequestParam(value = "name", required = false) String name) {
        return new HeyResponse(name == null ? "noname" : name, new Random().nextInt());
    }
}
