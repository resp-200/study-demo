package com.study_demo.genericParadigm;

public class ErrorLogger implements Logger<ErrorMessage> {
    @Override
    public void log(ErrorMessage message) {
        System.out.println("Logging Error: " + message.getContent());
    }
}