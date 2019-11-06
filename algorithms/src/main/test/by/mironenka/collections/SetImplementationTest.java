package by.mironenka.collections;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SetImplementationTest {

    @Test
    public void whenAddSameElementThenIncludeUniqueElement() {

        SetImplementation<Integer> set = new SetImplementation<>();
        set.put(1);
        set.put(2);
        set.put(2);
        Iterator<Integer> it = set.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(false));
    }

}