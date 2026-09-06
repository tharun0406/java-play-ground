
/**
 * Variables are named references to values. This lesson covers primitive
 * values, reference values, constants, scope, and safe type conversion.
 */
public class Variables {

    private static final double GST_RATE = 0.18;

    public static void main(String[] args) {
        // Primitive types store their actual value directly.
        int quantity = 3;
        long population = 1_428_600_000L; // L is required for large long literals.
        double unitPrice = 249.99;
        char section = 'A';
        boolean inStock = true;

        // String and arrays are reference types: the variable holds a reference
        // to an object. String itself is immutable; arrays are mutable.
        String customerName = "Tharun";
        int[] quantities = {1, 2, 3};
        quantities[0] = quantity;

        double subtotal = quantity * unitPrice;
        double total = subtotal + (subtotal * GST_RATE);

        System.out.println("Customer: " + customerName + ", section: " + section);
        System.out.println("Population: " + population + ", in stock: " + inStock);
        System.out.println("Invoice total: " + total);
        System.out.println("First quantity in mutable array: " + quantities[0]);

        demonstrateCasting();
        demonstrateScope();
    }

    private static void demonstrateCasting() {
        int itemCount = 7;
        double widenedValue = itemCount; // Widening: no information is lost.

        double price = 99.99;
        int truncatedPrice = (int) price; // Narrowing: explicit, drops decimals.
        long roundedPrice = Math.round(price); // Prefer this when rounding is intended.

        System.out.println("Widened int: " + widenedValue);
        System.out.println("Truncated price: " + truncatedPrice);
        System.out.println("Rounded price: " + roundedPrice);
    }

    private static void demonstrateScope() {
        String message = "Method-local variables are visible only in this method.";
        System.out.println(message);

        // GST_RATE is visible here because it is a class-level constant.
        System.out.println("GST rate: " + GST_RATE);
    }
}
