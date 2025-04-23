package com.study_demo.mcpserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author Zhang hao yu
 * @Date 2025/4/23 15:19
 */
@RestController
public class MyController {

    @RequestMapping("/test")
    public String test (String param) {
        System.out.println(param);
        return "test";
    }
}
