package by.mironenka.recursion;

public class Factorial {

    public static int factorial(int n) {
        int result = -1;

        if (n == 1) {
            result = 1;
        } else {
            result = n * factorial(n - 1);
        }
        return result;
    }

}
