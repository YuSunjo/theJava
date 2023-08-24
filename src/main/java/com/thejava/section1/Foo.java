package com.thejava.section1;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Foo {

    /**
     * 1. 함수형 인터페이스
     * 2. 람다 표현식
     * 3. 자바에서 함수형 프로그래밍
     *    - 함수를 First class object로 사용할 수 있다.
     *    - 순수 함수(Pure function)
     *    - 고차 함수(Higher-Order function)
     *    - 불변성
     *    link: https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html
     */
    public static void main(String[] args) {

        // 함수형 인터페이스와 람다 표현식
        RunSomething runSomething = () -> System.out.println("Hello");
        runSomething.doIt();

        // 자바에서 제공해주는 함수형 인터페이스
        Integer apply = new PlusTen().apply(1);

        Function<Integer, Integer> plusTen = (number) -> number + 10;
        Function<Integer, Integer> multiply2 = (number) -> number * 2;

        Function<Integer, Integer> compose = plusTen.compose(multiply2);

        Consumer<Integer> price = (i) -> System.out.println("price: " + i);

        Supplier<Integer> get10 = () -> 10;

        Predicate<String> startsWithThe = (s) -> s.startsWith("The");

    }

}
