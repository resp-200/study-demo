package com.langchain_study;

import dev.langchain4j.model.openai.OpenAiChatModel;

/**
 * @Description
 * @Author Zhang hao yu
 * @Date 2025/6/18 15:59
 */
public class Main {
    private static final String API_KEY = "";
    private static final String MODEL_NAME = "qwen-plus-latest";
    private static final String BASE_URL = "https://dashscope.aliyuncs.com/compatible-mode/v1";
//    private static final String BASE_URL = "https://dashscope.aliyuncs.com/compatible-mode/v1/chat/completions";

    public static OpenAiChatModel buildModel() {
        return OpenAiChatModel.builder()
                .baseUrl(BASE_URL)
                .apiKey(API_KEY)
                .modelName(MODEL_NAME)
                .build();
    }
    public static void main(String[] args) {
        OpenAiChatModel model = buildModel();
        String answer = model.chat("你好");
        System.out.println(answer);
    }

    
}
