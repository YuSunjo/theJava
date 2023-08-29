package com.thejava.java.section5;

import java.time.*;

public class Foo {

    public static void main(String[] args) {

        Instant now = Instant.now();// 현재 시간을 기계시간으로 표현 (UTC, GMT)
        now.atZone(ZoneId.systemDefault());

        LocalDateTime now1 = LocalDateTime.now();
        LocalDateTime.of(2019, 1, 1, 0, 0, 0);

        ZonedDateTime.of(now1, ZoneId.systemDefault());

        LocalDate now2 = LocalDate.now();
        LocalDate localDate = LocalDate.of(2019, Month.JANUARY, 1);
        Period.between(now2, localDate);

        Duration.between(localDate, now);




    }
}
