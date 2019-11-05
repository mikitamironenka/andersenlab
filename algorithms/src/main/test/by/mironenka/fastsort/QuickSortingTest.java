package by.mironenka.fastsort;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class QuickSortingTest {

    @Test
    public void whenQuickSort() {

        int[] arr = {5, 3, 4, 1, 2};
        QuickSorting.quickSort(arr, 0, arr.length-1);
        int[] checked = new int[]{1, 2, 3, 4, 5};
        assertThat(arr, is(checked));
    }
}