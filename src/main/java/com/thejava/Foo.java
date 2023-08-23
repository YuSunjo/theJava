package com.thejava;

public class Foo {

    /**
     * 1. 함수형 인터페이스
     * 2. 람다 표현식
     * 3. 자바에서 함수형 프로그래밍
     *    - 함수를 First class object로 사용할 수 있다.
     *    - 순수 함수(Pure function)
     *    - 고차 함수(Higher-Order function)
     *    - 불변성
     */
    public static void main(String[] args) {

        RunSomething runSomething = () -> System.out.println("Hello");
        runSomething.doIt();
    }

}
