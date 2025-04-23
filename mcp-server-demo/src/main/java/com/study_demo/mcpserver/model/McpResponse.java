package com.study_demo.mcpserver.model;

import lombok.Data;

@Data
public class McpResponse {
    private String contextId;
    private Object output;
    private Object metadata;
    private String status;
}