package com.study_demo.genericParadigm;

public interface Logger<T extends Message> {
    void log(T message);
}
