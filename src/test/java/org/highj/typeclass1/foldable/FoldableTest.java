package org.highj.typeclass1.foldable;

import org.highj.data.List;
import org.highj.data.Maybe;
import org.highj.data.num.Integers;
import org.junit.Test;

import java.util.function.Function;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class FoldableTest {

    private final Function<String, Function<String, String>> wrapFn = a -> b -> "(" + a + "," + b + ")";

    @Test
    public void fold()  {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        int result = List.traversable.fold(Integers.multiplicativeMonoid, numbers);
        assertEquals(120, result);
    }

    @Test
    public void foldMap()  {
        List<String> strings = List.of("a", "bb", "ccc", "dddd", "eeeee");
        int result = List.traversable.foldMap(Integers.multiplicativeMonoid, String::length, strings);
        assertEquals(120, result);
    }

    @Test
    public void foldr()  {
        List<String> strings = List.of("a", "e", "i", "o");
        String result = List.traversable.foldr(wrapFn, "u", strings);
        assertEquals("(a,(e,(i,(o,u))))", result);
    }

    @Test
    public void foldl()  {
        List<String> strings = List.of("e", "i", "o", "u");
        String result = List.traversable.foldl(wrapFn, "a", strings);
        assertEquals("((((a,e),i),o),u)", result);
    }

    @Test
    public void foldr1()  {
        List<String> strings = List.of("a", "e", "i", "o", "u");
        Maybe<String> result = List.traversable.foldr1(wrapFn, strings);
        assertEquals("(a,(e,(i,(o,u))))", result.get());
        List<String> noStrings = List.of();
        assertTrue(List.traversable.foldr1(wrapFn, noStrings).isNothing());
    }

    @Test
    public void foldl1()  {
        List<String> strings = List.of("a", "e", "i", "o", "u");
        Maybe<String> result = List.traversable.foldl1(wrapFn, strings);
        assertEquals("((((a,e),i),o),u)", result.get());
        List<String> noStrings = List.of();
        assertTrue(List.traversable.foldl1(wrapFn, noStrings).isNothing());
    }
}
