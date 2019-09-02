package com.example.order.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hongwei
 * @date 2019/8/26 22:08
 */
@RestController
public class EnvController {
    @Value("${env}")
    private String env;

    @GetMapping("print")
    public String print(){
        return env;
    }

    @GetMapping("check")
    public String check(){
        return "success";
    }
}
