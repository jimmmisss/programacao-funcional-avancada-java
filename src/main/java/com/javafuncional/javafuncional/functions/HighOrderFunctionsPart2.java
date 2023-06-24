package com.javafuncional.javafuncional.functions;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Stream;

public class HighOrderFunctionsPart2 {

    public static void main(String[] args) {

        Function<Integer, String> intToString = new Function<Integer, String>() {
            @Override
            public String apply(Integer i) {
                return i.toString();
            }
        };

        Function<Integer, String> intToStringLambda = i -> i.toString();

        Stream.of(1, 2, 3).map(intToString);
        Stream.of(1, 2, 3).map(intToStringLambda);

        Function<String, String> algAddictional = s -> s.replaceAll("o", "0");
        String msgEncrypted = encripta("hello", algAddictional);
        System.out.println(msgEncrypted);

        BiFunction<String, Integer, String> show = new BiFunction<String, Integer, String>() {
            @Override
            public String apply(String name, Integer age) {
                return "Hello, my name is " + name + " I have " + age + " years";
            }
        };

        BiFunction<String, Integer, String> showLambda = (name, age) -> "Hello, my name is " + name + " I have " + age + " years";

        System.out.println(show.apply("Isadora", 10));
        System.out.println(showLambda.apply("Jimmy", 1));

        BiFunction<String, Function<String, String>, String> fEncrypt =
                new BiFunction<String, Function<String, String>, String>() {
                    @Override
                    public String apply(String msg, Function<String, String> alg) {
                        var msgNew = msg.replaceAll("a", "4");
                        return alg.apply(msgNew);
                    }
                };

        BiFunction<String, Function<String, String>, String> fEncryptLambda =
                (msg, alg) -> {
                    var msgNew = msg.replaceAll("a", "4");
                    return alg.apply(msgNew);
                };

        System.out.println(fEncrypt.apply("ola", s -> s.replaceAll("o", "0")));
        System.out.println(fEncryptLambda.apply("ola", s -> s.replaceAll("o", "0")));

    }

    public static String encripta(String msg, Function<String, String> algAddictional) {
        var msgEncrypt = msg.replaceAll("a", "4");
        var algSuperEncrypt = algAddictional.apply(msgEncrypt);
        return algSuperEncrypt;
    }
}
