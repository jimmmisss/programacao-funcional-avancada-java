package com.javafuncional.javafuncional.functions;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Identity {

    public static String encripta(String msg, Function<String, String> alg) {
        var msgEncrypt = msg.replaceAll("a", "4");
        return alg.apply(msgEncrypt);
    }

    public static void main(String[] args) {

        System.out.println(encripta("Hello", s -> s));

        Map<Integer, Long> noteOccurrence = Stream.of(10, 10, 0, 8, 8, 8)
                .collect(Collectors.groupingBy(
                        e -> e,
                        Collectors.counting()
                ));

        System.out.println(noteOccurrence);

        Stream<Integer> integerStream = Stream.of(Stream
                        .of(1, 2, 3), Stream.of(4, 5, 6), Stream.of(7, 8, 9))
                .flatMap(s -> s);

        integerStream.forEach(System.out::println);
    }
}
