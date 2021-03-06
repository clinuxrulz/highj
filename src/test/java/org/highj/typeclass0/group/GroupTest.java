package org.highj.typeclass0.group;

import org.highj.data.num.Integers;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class GroupTest {
    @Test
    public void times() throws Exception {
        Group<Integer> group = Integers.additiveGroup;

        assertThat(group.times(42, 0)).isEqualTo(0);

        Integer result = group.times(10, 123);
        assertThat(result).isEqualTo(1230);

        Integer negativeResult = group.times(10, -123);
        assertThat(negativeResult).isEqualTo(-1230);
    }

    @Test
    public void create() throws Exception {
        Group<Integer> group = Group.create(0, (x, y) -> x + y, z -> -z);
        assertThat(group.identity()).isEqualTo(0);
        assertThat(group.apply(46, 54)).isEqualTo(100);
        assertThat(group.inverse(42)).isEqualTo(-42);
    }
}