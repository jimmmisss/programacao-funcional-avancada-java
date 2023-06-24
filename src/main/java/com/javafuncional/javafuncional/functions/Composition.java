package com.javafuncional.javafuncional.functions;

import static com.javafuncional.javafuncional.functions.Function.compose;

public class Composition {

    public static void main(String[] args) {

        Function<String, String> toUnderscore = s -> s.replaceAll(" ", "_");
        Function<String, String> toLowercase = String::toLowerCase;
        System.out.println(toUnderscore.apply(toLowercase.apply("Class Compose Function")));

        Function<String, String> toSnakeCase = compose(toLowercase, toUnderscore);
        System.out.println(toSnakeCase.apply("Class Compose Function"));

        Function<Integer, String> intToString = i -> i.toString();
        Function<Double, Integer> doubleToInt = d -> d.intValue();

        Function<Double, String> doubleToString = Function.compose(intToString, doubleToInt);
        System.out.println(doubleToString.apply(16.30));

        Function<Double, String> doubleToStringTypeJava = intToString.compose(doubleToInt);
        System.out.println(doubleToStringTypeJava);

    }
}
