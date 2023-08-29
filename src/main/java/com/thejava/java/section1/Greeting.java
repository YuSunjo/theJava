package com.thejava.java.section1;

public class Greeting {

    private String name;

    public Greeting() {
    }

    public Greeting(String name) {
        this.name = name;
    }

    public static String hello(String name) {
        return "hello " + name;
    }

    public String hi(String name) {
        return "hi " + name;
    }

    public String getName() {
        return name;
    }

}