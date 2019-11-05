package by.mironenka.fastsort;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RecursiveSumTest {

    @Test
    public void whenCalcRecursiveSummThenReturnTen() {
        int result = RecursiveSum.recursiveSum(new int[]{1, 2, 3, 4});
        assertThat(result, is(10));
    }

}