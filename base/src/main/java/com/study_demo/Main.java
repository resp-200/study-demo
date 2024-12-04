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

        List<Number> numbers = new ArrayList<>();
        List<Object> objects = new ArrayList<>();
        addNumber(list, objects);
        addNumber2(list, objects);
    }
    public static void addNumber(List<? extends Number> list, List<Number> numbers){
        numbers.addAll(list);
    }
    public static void addNumber2(List<? extends Number> list, List<? super Number> numbers){
        numbers.addAll(list);
    }

}