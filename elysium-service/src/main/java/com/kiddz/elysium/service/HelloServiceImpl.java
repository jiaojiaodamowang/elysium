package com.kiddz.elysium.service;

import com.kiddz.elysium.api.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello() {
        return "Hi, SpringBoot!";
    }
}
