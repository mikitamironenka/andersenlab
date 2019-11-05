package by.mironenka.binarysearch;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void whenNumberThreeThenReturnOne() {
        int[] arr = new int[]{1, 3, 5, 7, 9};
        int result = new BinarySearch().findNumberLocation(arr, 3);
        int checked = 1;
        assertThat(result, is(checked));
    }

    @Test
    public void whenNumberTenThenReturnMinusOne() {
        int[] arr = new int[]{1, 3, 5, 7, 9};
        int result = new BinarySearch().findNumberLocation(arr, 10);
        int checked = -1;
        assertThat(result, is(checked));
    }

}