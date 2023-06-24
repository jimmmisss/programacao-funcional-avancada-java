package com.javafuncional.javafuncional.functions;

public class HighOrderFunctionsPart1 {

    public static void main(String[] args) {
        Function<String, Function<String, String>> greetingForName =
                new Function<String, Function<String, String>>() {
                    @Override
                    public Function<String, String> apply(final String greeting) {
                        return new Function<String, String>() {
                            @Override
                            public String apply(String name) {
                                return greeting + ", " + name;
                            }
                        };
                    }
                };

        Function<String, Function<String, String>> greetingLambda =
                greeting -> (name -> greeting + ", " + name);
        System.out.println(greetingLambda.apply("Good evening").apply("Isabel"));

        Function<String, String> goodMorningFor = greetingForName.apply("Good morning");
        String greetingGoodMorningIsadora = goodMorningFor.apply("Isadora");
        System.out.println(greetingGoodMorningIsadora);
        System.out.println(goodMorningFor.apply("Isabel"));
        System.out.println(greetingForName.apply("Good night").apply("Wesley Pereira"));


        Function<Integer, Function<Integer, Function<Integer, Integer>>> f1 =
                i1 -> i2 -> i3 -> i1 + i2 + i3;

        Function<Integer, Function<Integer, Integer>> f2 = f1.apply(1);
        Function<Integer, Integer> f3 = f2.apply(2);
        System.out.println(f3.apply(3));
    }
}
