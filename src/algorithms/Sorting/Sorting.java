
import java.util.Arrays;

/**
 * Sorting examples. Each method returns a sorted copy so callers keep their
 * original input. In production, prefer Arrays.sort unless you specifically
 * need to understand or customise the algorithm.
 */
public class Sorting {

    public static void main(String[] args) {
        int[] values = {29, 10, 14, 37, 13};

        System.out.println("Original:       " + Arrays.toString(values));
        System.out.println("Bubble sort:    " + Arrays.toString(bubbleSort(values)));
        System.out.println("Insertion sort: " + Arrays.toString(insertionSort(values)));
        System.out.println("Merge sort:     " + Arrays.toString(mergeSort(values)));
        System.out.println("Still original: " + Arrays.toString(values));
    }

    /**
     * Bubble sort repeatedly swaps neighbouring out-of-order elements.
     * Best case O(n) with the early-exit flag; average/worst case O(n^2).
     */
    public static int[] bubbleSort(int[] input) {
        int[] sorted = copyOf(input);
        for (int end = sorted.length - 1; end > 0; end--) {
            boolean swapped = false;
            for (int index = 0; index < end; index++) {
                if (sorted[index] > sorted[index + 1]) {
                    swap(sorted, index, index + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return sorted;
    }

    /**
     * Insertion sort grows a sorted left side one value at a time.
     * It is O(n^2), but performs well for very small or nearly-sorted input.
     */
    public static int[] insertionSort(int[] input) {
        int[] sorted = copyOf(input);
        for (int index = 1; index < sorted.length; index++) {
            int value = sorted[index];
            int previous = index - 1;
            while (previous >= 0 && sorted[previous] > value) {
                sorted[previous + 1] = sorted[previous];
                previous--;
            }
            sorted[previous + 1] = value;
        }
        return sorted;
    }

    /**
     * Merge sort divides the input, sorts both halves, then merges them.
     * Its time complexity is O(n log n) and it needs O(n) auxiliary space.
     */
    public static int[] mergeSort(int[] input) {
        int[] sorted = copyOf(input);
        int[] buffer = new int[sorted.length];
        mergeSort(sorted, buffer, 0, sorted.length);
        return sorted;
    }

    private static void mergeSort(int[] values, int[] buffer, int from, int to) {
        if (to - from <= 1) {
            return;
        }
        int middle = from + (to - from) / 2;
        mergeSort(values, buffer, from, middle);
        mergeSort(values, buffer, middle, to);
        merge(values, buffer, from, middle, to);
    }

    private static void merge(int[] values, int[] buffer, int from, int middle, int to) {
        int left = from;
        int right = middle;
        int destination = from;
        while (left < middle && right < to) {
            buffer[destination++] = values[left] <= values[right] ? values[left++] : values[right++];
        }
        while (left < middle) {
            buffer[destination++] = values[left++];
        }
        while (right < to) {
            buffer[destination++] = values[right++];
        }
        System.arraycopy(buffer, from, values, from, to - from);
    }

    private static int[] copyOf(int[] input) {
        if (input == null) {
            throw new IllegalArgumentException("Input array must not be null");
        }
        return Arrays.copyOf(input, input.length);
    }

    private static void swap(int[] values, int first, int second) {
        int temporary = values[first];
        values[first] = values[second];
        values[second] = temporary;
    }
}
