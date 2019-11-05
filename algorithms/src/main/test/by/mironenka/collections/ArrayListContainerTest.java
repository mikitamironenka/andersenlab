package by.mironenka.collections;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ArrayListContainerTest {

    private ArrayListContainer<Integer> list;

    @Before
    public void init() {
        list = new ArrayListContainer();
    }

    @Test
    public void whenAddElementThenReturnIt() {
        list.add(1);
        assertThat(list.get(0), is(1));
    }

    @Test
    public void whenRemoveElementThenSizeLess() {
        list.add(1);
        list.add(2);
        list.remove(0);
        assertThat(list.get(0), is(2));
        assertThat(list.getElements(), is(1));
    }

    @Test
    public void whenIterateThrowTheList() {
        list.add(1);
        list.add(2);
        Iterator it = list.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNoNextElementThenNoSuchElementExceptionThrow() {
        Iterator it = list.iterator();
        it.next();
    }
}