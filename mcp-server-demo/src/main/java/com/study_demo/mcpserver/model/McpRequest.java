package com.study_demo.mcpserver.model;

import lombok.Data;

@Data
public class McpRequest {
    private String model;
    private String contextId;
    private Object input;
    private Object parameters;
}