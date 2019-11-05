package by.mironenka.fastsort;

import java.util.stream.IntStream;

public class RecursiveSum {

    public static int recursiveSum(int[] arr) {
        int result = 0;
        if (arr.length == 0) {
            result = 0;
        } else {
            result = arr[0] + recursiveSum(removeTheElement(arr, 0));
        }
        return result;
    }

    private static int[] removeTheElement(int[] arr, int index) {

        int[] result = arr;
        // If the array is empty
        // or the index is not in array range
        // return the original array
        if ( !(arr == null
                || index < 0
                || index >= arr.length)) {
            result = IntStream.range(0, arr.length)
                    .filter(i -> i != index)
                    .map(i -> arr[i])
                    .toArray();
        }

        return result;
    }

}
