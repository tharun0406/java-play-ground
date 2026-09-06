
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Dynamic programming solves problems with overlapping subproblems by storing
 * answers that would otherwise be recalculated. Typical approaches are
 * top-down memoisation and bottom-up tabulation.
 */
public class DynamicProgramming {

    public static void main(String[] args) {
        System.out.println("Fibonacci (memoisation): " + fibonacciMemoized(10));
        System.out.println("Fibonacci (tabulation): " + fibonacciTabulated(10));
        System.out.println("Minimum coins for 11: " + minimumCoins(11, new int[] {1, 5, 6, 8}));
        System.out.println("LCS length for 'stone' and 'longest': "
                + longestCommonSubsequenceLength("stone", "longest"));
    }

    /** Top-down DP: recurse first, cache each calculated result. O(n) time/space. */
    public static long fibonacciMemoized(int n) {
        requireNonNegative(n);
        Map<Integer, Long> cache = new HashMap<Integer, Long>();
        cache.put(0, 0L);
        cache.put(1, 1L);
        return fibonacciMemoized(n, cache);
    }

    private static long fibonacciMemoized(int n, Map<Integer, Long> cache) {
        Long knownValue = cache.get(n);
        if (knownValue != null) {
            return knownValue;
        }
        long calculated = fibonacciMemoized(n - 1, cache) + fibonacciMemoized(n - 2, cache);
        cache.put(n, calculated);
        return calculated;
    }

    /** Bottom-up DP: start from the smallest cases and build to n. O(n) time, O(1) space. */
    public static long fibonacciTabulated(int n) {
        requireNonNegative(n);
        if (n < 2) {
            return n;
        }
        long previous = 0;
        long current = 1;
        for (int value = 2; value <= n; value++) {
            long next = previous + current;
            previous = current;
            current = next;
        }
        return current;
    }

    /**
     * Unbounded coin-change minimisation. dp[value] stores the fewest coins
     * needed to make value. Returns -1 if the amount cannot be made.
     */
    public static int minimumCoins(int amount, int[] denominations) {
        requireNonNegative(amount);
        if (denominations == null || denominations.length == 0) {
            throw new IllegalArgumentException("At least one denomination is required");
        }
        int[] minimum = new int[amount + 1];
        Arrays.fill(minimum, amount + 1);
        minimum[0] = 0;

        for (int denomination : denominations) {
            if (denomination <= 0) {
                throw new IllegalArgumentException("Denominations must be positive");
            }
            for (int value = denomination; value <= amount; value++) {
                minimum[value] = Math.min(minimum[value], minimum[value - denomination] + 1);
            }
        }
        return minimum[amount] == amount + 1 ? -1 : minimum[amount];
    }

    /**
     * Longest common subsequence (LCS) uses a table of smaller prefix answers.
     * Time and space complexity are both O(left.length * right.length).
     */
    public static int longestCommonSubsequenceLength(String left, String right) {
        if (left == null || right == null) {
            throw new IllegalArgumentException("Strings must not be null");
        }
        int[][] lengths = new int[left.length() + 1][right.length() + 1];
        for (int leftIndex = 1; leftIndex <= left.length(); leftIndex++) {
            for (int rightIndex = 1; rightIndex <= right.length(); rightIndex++) {
                if (left.charAt(leftIndex - 1) == right.charAt(rightIndex - 1)) {
                    lengths[leftIndex][rightIndex] = lengths[leftIndex - 1][rightIndex - 1] + 1;
                } else {
                    lengths[leftIndex][rightIndex] = Math.max(
                            lengths[leftIndex - 1][rightIndex], lengths[leftIndex][rightIndex - 1]);
                }
            }
        }
        return lengths[left.length()][right.length()];
    }

    private static void requireNonNegative(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Value must be non-negative");
        }
    }
}
