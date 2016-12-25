import java.lang.reflect.Method;
import java.util.function.Function;

public class HaskellType {
    // data MyType = ValueAConstructor a | ValueBConstructor b

    interface Type {
        Class<? extends Type> getType();
        Method getConstructor();
        Object[] getArgs();
    }

    interface MyType extends Type{
        static MyType ValueAConstructor(String a) {
            return new MyType() {

                @Override
                public Class<? extends Type> getType() {
                    return MyType.class;
                }

                @Override
                public Method getConstructor() {
                    try {
                        return MyType.class.getDeclaredMethod("ValueAConstructor", String.class);
                    } catch (NoSuchMethodException e) {
                        throw new RuntimeException(e);
                    }
                }

                @Override
                public Object[] getArgs() {
                    return new Object[] { a };
                }
            };
        }
    }

    interface MyType2<T> {
        static <U> MyType2<U> ValueConstructorA(U u) {
            return new MyType2<U>() {
            };
        }

    }

    interface Functor<F> {

        <A, B>   Functor<B> fmap(Function<A, B> func, Functor<A> functor);

    }

}
