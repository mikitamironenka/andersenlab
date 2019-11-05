package by.mironenka.binarysearch;

public class BinarySearch {

    public int findNumberLocation(int[] array, int number) {
        int result = -1;
        int low = 0;
        int high = array.length - 1;
        int mid;
        int guess;

        while (low <= high) {
            mid = (high + low) / 2;
            guess = array[mid];
            if (guess == number) {
                result = mid;
                break;
            } else if (guess > number) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

}
