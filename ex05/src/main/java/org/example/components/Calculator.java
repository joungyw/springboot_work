package org.example.components;


import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class Calculator {

    public void doPrint() {
        Stream.of(11, 22, 33, 44, 55, 66, 77, 88, 99, 100)
                .forEach(System.out::println);
    }
}
