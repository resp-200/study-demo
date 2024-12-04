package com.study_demo.genericParadigm;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author Zhang hao yu
 * @Date 2024/12/4 14:08
 */
@Data
public class Message {
    private String content;

    public Message(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}


