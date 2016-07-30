package org.highj.data.instance.either3;

import org.derive4j.hkt.__;
import org.highj.data.Either3;
import org.highj.typeclass1.functor.Functor;

import java.util.function.Function;

public interface Either3Functor<S,T> extends Functor<__<__<Either3.µ,S>,T>> {
    @Override
    default <A, B> Either3<S, T, B> map(Function<A, B> fn, __<__<__<Either3.µ, S>, T>, A> nestedA) {
        return Either3.narrow(nestedA).rightMap(fn);
    }
}