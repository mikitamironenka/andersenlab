package by.mironenka.selectionsort;

import java.util.stream.IntStream;

public class SelectionSorter {

    public int indexOfSmallestElement(int[] arr) {
        int result = 0;
        int smallest = arr[result];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < smallest) {
                smallest = arr[i];
                result = i;
            }
        }
        return result;
    }

    public int[] selectionSort(int[] arr) {
        int[] result = new int[arr.length];
        int smallest;
        int index = 0;
        while (arr.length > 0) {
            smallest = indexOfSmallestElement(arr);
            result[index] = arr[smallest];
            arr = removeTheElement(arr, smallest);
            index++;
        }
        return result;
    }


    public int[] removeTheElement(int[] arr, int index) {

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
