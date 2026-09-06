
import java.util.Arrays;

/**
 * Searching examples. Both methods return an index or -1 when the target is
 * absent. Binary search is fast only when its input is already sorted.
 */
public class Searching {

    public static void main(String[] args) {
        int[] unsorted = {42, 7, 19, 7, 88};
        int[] sorted = {7, 19, 42, 88, 101};

        System.out.println("Linear search for 19: " + linearSearch(unsorted, 19));
        System.out.println("Binary search for 42: " + binarySearch(sorted, 42));
        System.out.println("Binary search for 50: " + binarySearch(sorted, 50));
        System.out.println("JDK binary search: " + Arrays.binarySearch(sorted, 88));
    }

    /** Linear search checks each value: O(n), and does not require sorting. */
    public static int linearSearch(int[] values, int target) {
        requireArray(values);
        for (int index = 0; index < values.length; index++) {
            if (values[index] == target) {
                return index;
            }
        }
        return -1;
    }

    /**
     * Iterative binary search: O(log n). The values must be in ascending order.
     * midpoint is calculated this way to avoid integer overflow.
     */
    public static int binarySearch(int[] sortedValues, int target) {
        requireArray(sortedValues);
        int low = 0;
        int high = sortedValues.length - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;
            int middleValue = sortedValues[middle];
            if (middleValue == target) {
                return middle;
            }
            if (middleValue < target) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }

    private static void requireArray(int[] values) {
        if (values == null) {
            throw new IllegalArgumentException("Input array must not be null");
        }
    }
}
