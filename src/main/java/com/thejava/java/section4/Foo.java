package com.thejava.java.section4;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Foo {

    public static void main(String[] args) {
        // optional

        List<Online> onlineList = new ArrayList<>();
        onlineList.add(new Online(1L, "spring boot", true));
        onlineList.add(new Online(2L, "spring data jpa", true));

        Optional<Online> online = onlineList.stream()
                .filter(o -> o.getTitle().startsWith("spring"))
                .findFirst();

//        boolean present = online.isPresent();

//        Online online1 = online.orElse(createNewOnline());

        online.orElseGet(Foo::createNewOnline);

    }

    private static Online createNewOnline() {
        return new Online(10L, "new spring", true);
    }


}
