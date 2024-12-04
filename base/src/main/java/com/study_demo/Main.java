package com.study_demo;

import com.study_demo.genericParadigm.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        List<Double> list = new ArrayList<>();
        list.add(1.0);
        list.add(2.0);
        consumer1(list);
        consumer(list);
    }
    public static void consumer1(List<Number> list){
        list.forEach(System.out::println);
    }
    public static void consumer(List<? extends Number> list){
        list.forEach(System.out::println);
    }

}