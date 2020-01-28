package com.kiddz.elysium.web.controller;

import com.kiddz.elysium.api.HelloService;
import com.kiddz.elysium.web.response.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;

@Controller
public class HelloWorldController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldController.class);

    @Resource
    private HelloService helloService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public Result sayHello() {
        try {
            String result = helloService.sayHello();
            return Result.success(result);
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    @RequestMapping(value = "/currenttime", method = RequestMethod.GET)
    @ResponseBody
    public String getCurrentTime() {
        return new Date().toString();
    }

}