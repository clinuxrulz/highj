package org.highj.data.ord.instances;

import org.derive4j.hkt.__;
import org.highj.Hkt;
import org.highj.data.ord.Ord1;
import org.highj.typeclass1.contravariant.Contravariant1;
import org.highj.typeclass2.injective.Function1;


public interface Ord1Contravariant1 extends Contravariant1<Ord1.µ> {

    @Override
    default <A, B> Ord1<A> contramap(Function1<A, B> fn, __<Ord1.µ, B> nestedB) {
        return Hkt.asOrd1(nestedB).contramap(fn);
    }
}
