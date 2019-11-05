package by.mironenka.recursion;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FactorialTest {

    @Test
    public void whenCalcFactorialThreeThenReturnSix() {
        int result = Factorial.factorial(3);
        assertThat(result, is(6));
    }

}