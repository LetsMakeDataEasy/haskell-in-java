package haskellinjava;

import java.util.function.Function;

class Maybe<A> implements Functor<A, Maybe<?>> {

    private final A v;

    Maybe(A t) {
        this.v = t;
    }

    static <T> Maybe<T> Just(T u) {
        return new Maybe<T>(u);
    }

    static <A> Maybe<A> Nothing() {
        return new Maybe<A>(null);
    }

    @Override
    public <B> Maybe<B> fmap(Function<A, B> fn) {
        if (v == null) {
            return new Maybe<B>(null);
        }
        return Just(fn.apply(v));
    }

    public static void test() {
        Maybe.Just("String")
                .fmap(String::toLowerCase)
                .fmap(String::toUpperCase);
    }
}

