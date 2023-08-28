package com.thejava.section3;

import java.util.ArrayList;
import java.util.List;

public class Foo {

    public static void main(String[] args) {

        // 인터페이스 기본 메서드, 스태틱 메서드

        // 기본 메서드로 인해서 변화된 API - iterator, Collection, Comparator
        List<String> names = new ArrayList<>();
        names.add("theJava");
        names.add("whiteship");

        names.stream().map(String::toUpperCase).forEach(System.out::println);
        // 병렬이 더 느릴수도 있음 - 컨텍스트 스위칭 비용, 스레드 만드는 비용(스레드 이름을 찍어보면 여러개의 쓰레드가 있음)
        names.parallelStream().map(String::toUpperCase).forEach(System.out::println);

    }
}
