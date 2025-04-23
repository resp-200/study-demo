package com.study_demo;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Application {
    public static void main(String[] args){
        try {
            new SpringApplicationBuilder().sources(Application.class).web(WebApplicationType.SERVLET).run(args);
        }catch (Throwable e){
            System.out.println("服务启动异常");
            System.exit(-1);
        }
    }
}