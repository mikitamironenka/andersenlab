package by.mironenka.fastsort;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BiggestNumberFinderTest {

    @Test
    public void whenFindBiggestThenReturnFive() {
        int result = BiggestNumberFinder.findBiggest(new int[]{4, -15, 0, -55, 1, 5});
        assertThat(result, is(5));
    }
}