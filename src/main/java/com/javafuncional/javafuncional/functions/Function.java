package com.javafuncional.javafuncional.functions;

@FunctionalInterface
public interface Function<T, R> {

    public R apply(T i);

    static <T> Function<T, T> identity() {
        return e -> e;
    }

    static <T, R, V> Function<V, R> compose(Function<T, R> f, Function<V, T> g) {
        return d -> f.apply(g.apply(d));
    }

    default <V> Function<V, R> compose(Function<V, T> g) {
        return v -> this.apply(g.apply(v));
    }
}
