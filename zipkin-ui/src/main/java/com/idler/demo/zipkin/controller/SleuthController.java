package com.idler.demo.zipkin.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SleuthController {

    @ResponseBody
    @RequestMapping("/sayHello/{name}")
    public String sayHello(@PathVariable String name) {
        return "hello " + name;
    }

    @ResponseBody
    @RequestMapping("/sayHello2/{name}")
    public String sayHello2(@PathVariable String name) {
        return "hello " + name;
    }
}