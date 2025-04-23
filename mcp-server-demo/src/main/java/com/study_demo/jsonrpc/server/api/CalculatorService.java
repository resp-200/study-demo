package com.study_demo.jsonrpc.server.api;
import com.googlecode.jsonrpc4j.JsonRpcMethod;

public interface CalculatorService {
    @JsonRpcMethod("Calculator.add")
    int add(int a, int b);
    
    @JsonRpcMethod("Calculator.subtract")
    int subtract(int a, int b);
    
    @JsonRpcMethod("Calculator.multiply")
    int multiply(int a, int b);
    
    @JsonRpcMethod("Calculator.divide")
    double divide(int a, int b) throws ArithmeticException;
}