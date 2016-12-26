import java.util.function.Function;

interface Functor2<A> {
    <B> Functor2<B> apply(Function<A, B> fn);

    static <A, B> Function<Functor2<A>, Functor2<B>> fmap(Function<A, B> fn) {
        return (fa) -> fa.apply(fn);
    }
}