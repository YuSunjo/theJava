package com.thejava.section1;

import java.util.function.Function;

public class PlusTen implements Function<Integer, Integer> {
    @Override
    public Integer apply(Integer integer) {
        return integer + 10;
    }
}
