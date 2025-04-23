package com.study_demo.mcpserver.controller;

import com.study_demo.mcpserver.model.McpRequest;
import com.study_demo.mcpserver.model.McpResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mcp")
public class McpController {

    @PostMapping("/execute")
    public McpResponse execute(@RequestBody McpRequest request) {
        McpResponse response = new McpResponse();
        response.setContextId(request.getContextId());
        response.setStatus("SUCCESS");
        
        // 简单的处理逻辑
        if (request.getInput() instanceof String) {
            String input = (String) request.getInput();
            response.setOutput("Processed: " + input.toUpperCase());
        } else {
            response.setOutput(request.getInput());
        }
        
        response.setMetadata("Demo MCP Server v1.0");
        return response;
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "MCP Server is running";
    }
}