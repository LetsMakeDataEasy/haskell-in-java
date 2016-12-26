import java.util.function.Function;

class MaybeTest2<A> implements Functor2<A> {

    private final A v;

    MaybeTest2(A t) {
        this.v = t;
    }

    static <T> MaybeTest2<T> Just(T u) {
        return new MaybeTest2<T>(u);
    }

    static <A> MaybeTest2<A> Nothing() {
        return new MaybeTest2<A>(null);
    }

    @Override
    public <B> Functor2<B> apply(Function<A, B> fn) {
        if (v == null) {
            return new MaybeTest2<B>(null);
        }
        return Just(fn.apply(v));
    }

    public static void test() {
        Function<String, String> toUpperCase = String::toUpperCase;
        Function<String, String> toLowerCase = String::toLowerCase;
        Function<String, String> fn = toUpperCase.andThen(toLowerCase);
        Function<Functor2<String>, Functor2<String>> fmap = Functor2.fmap(fn);
        fmap.apply(Just("String"));
    }

}

