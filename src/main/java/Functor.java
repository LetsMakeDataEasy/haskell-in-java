import java.util.function.Function;

interface Functor<A, F extends Functor<?, ?>> {
    <B> F fmap(Function<A, B> fn);
}