package com.thejava.java.section2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;

public class Foo {

    public static void main(String[] args) {

        // 인터페이스 기본 메서드, 스태틱 메서드

        // 기본 메서드로 인해서 변화된 API - iterator, Collection, Comparator
        List<String> names = new ArrayList<>();
        names.add("theJava");
        names.add("whiteship");

        names.forEach(System.out::println);
        Spliterator<String> spliterator = names.spliterator();
        Spliterator<String> spliterator1 = spliterator.trySplit();
        while (spliterator.tryAdvance(System.out::println));

        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        names.sort(compareToIgnoreCase);

    }
}
