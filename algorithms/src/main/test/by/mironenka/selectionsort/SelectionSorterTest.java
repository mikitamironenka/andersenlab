package by.mironenka.selectionsort;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SelectionSorterTest {

    @Test
    public void whenSortArrayThenReturnSortedArray() {
        int[] arr = new int[]{5, 3, 1, 4, 2};
        int[] checked = new int[]{1, 2, 3, 4, 5};

        int[] result = new SelectionSorter().selectionSort(arr);

        assertThat(result, is(checked));
    }

    @Test
    public void whenRemoveElementThenArraySizeLess() {
        int[] arr = new int[]{5, 3, 1, 4, 2};

        arr = new SelectionSorter().removeTheElement(arr, 0);
        int result = arr.length;

        assertThat(result, is(4));
        assertThat(arr[0], is(3));
    }

}