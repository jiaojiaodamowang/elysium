package com.kiddz.elysium.demo.controller;

import com.alibaba.fastjson.JSON;
import com.kiddz.elysium.demo.domain.Student;
import com.kiddz.elysium.demo.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class HelloWorldController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldController.class);

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String sayHello() {
        return "Hello，Spring Boot！";
    }

    @RequestMapping(value = "/currenttime", method = RequestMethod.GET)
    @ResponseBody
    public String getCurrentTime() {
        LOGGER.info("request coming");
        return new Date().toString();
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(@PathVariable int id) {
        Student student = this.studentService.getStudent(id);
        return JSON.toJSONString(student);
    }

}