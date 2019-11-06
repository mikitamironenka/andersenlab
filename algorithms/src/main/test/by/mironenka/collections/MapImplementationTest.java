package by.mironenka.collections;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MapImplementationTest {

    @Test
    public void whenAddElementThenShouldReturnTrue(){

        MapImplementation<Integer, Integer> myMap = new MapImplementation<>();
        myMap.insert(1, 1);
        myMap.insert(2, 2);
        myMap.insert(2, 4);

        boolean resultAdd = myMap.insert(3, 3);

        assertThat(resultAdd, is(true));
        assertThat(myMap.get(2), is(4));
        assertThat(myMap.getSize(), is(3));
    }

    @Test
    public void whenDeleteElementThenShouldReturnTrue(){

        MapImplementation<Integer, Integer> myMap = new MapImplementation<>();
        myMap.insert(1, 1);
        myMap.insert(2, 2);
        myMap.insert(3, 3);

        boolean resultDelete = myMap.delete(2);

        assertThat(resultDelete, is(true));
        assertThat(myMap.getSize(), is(2));
    }

    @Test
    public void whenIterateElementThenShouldReturnNext(){

        MapImplementation<Integer, Integer> map = new MapImplementation<>();
        map.insert(1, 1);
        map.insert(2, 2);
        map.insert(3, 3);

        Iterator it = map.iterator();

        boolean hasNextFirst = it.hasNext();
        Integer valueOne = (Integer) it.next();
        Integer valueTwo = (Integer) it.next();
        it.next();
        boolean hasNextLast = it.hasNext();

        assertThat(hasNextFirst, is(true));
        assertThat(valueOne, is(1));
        assertThat(valueTwo, is(2));
        assertThat(hasNextLast, is(false));
    }

}