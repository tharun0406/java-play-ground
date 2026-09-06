
/**
 * Methods group reusable behaviour behind a meaningful name. Prefer small,
 * focused methods with clear inputs, outputs, and validation at boundaries.
 */
public class Functions {

    public static void main(String[] args) {
        String name = normaliseName("  tharun kumar  ");
        double invoiceTotal = calculateInvoiceTotal(2, 499.50, 0.18);

        System.out.println("Welcome, " + name);
        System.out.println("Invoice total: " + invoiceTotal);
        System.out.println("Sum using varargs: " + sum(4, 8, 15, 16, 23, 42));
        System.out.println("2 to the power of 8: " + power(2, 8));
    }

    /** A pure function: the result depends only on its arguments. */
    public static double calculateInvoiceTotal(int quantity, double unitPrice, double taxRate) {
        if (quantity < 0 || unitPrice < 0 || taxRate < 0) {
            throw new IllegalArgumentException("Quantity, price, and tax rate must be non-negative");
        }
        double subtotal = quantity * unitPrice;
        return subtotal + (subtotal * taxRate);
    }

    /** Returns a cleaned display name without changing the caller's String. */
    public static String normaliseName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name is required");
        }
        String[] words = name.trim().toLowerCase().split("\\s+");
        StringBuilder normalised = new StringBuilder();
        for (String word : words) {
            if (normalised.length() > 0) {
                normalised.append(' ');
            }
            normalised.append(Character.toUpperCase(word.charAt(0)))
                    .append(word.substring(1));
        }
        return normalised.toString();
    }

    /** Varargs lets callers pass zero or more integer arguments. */
    public static int sum(int... values) {
        int total = 0;
        for (int value : values) {
            total += value;
        }
        return total;
    }

    /** Recursion example: a method calls itself with a smaller problem. */
    public static long power(int base, int exponent) {
        if (exponent < 0) {
            throw new IllegalArgumentException("This integer example needs a non-negative exponent");
        }
        if (exponent == 0) {
            return 1;
        }
        return base * power(base, exponent - 1);
    }
}
