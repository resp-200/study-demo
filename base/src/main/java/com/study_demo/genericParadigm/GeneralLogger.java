package com.study_demo.genericParadigm;

public class GeneralLogger implements Logger<Message> {
    @Override
    public void log(Message message) {
        System.out.println("Logging: " + message.getContent());
    }
}

