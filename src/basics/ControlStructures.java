
/**
 * Control structures choose which code executes and how often it repeats.
 * Keep conditions readable; move complex decisions into named boolean methods.
 */
public class ControlStructures {

    public static void main(String[] args) {
        int score = 78;
        String grade = gradeFor(score);
        System.out.println("Score " + score + " gives grade " + grade);

        printShippingMessage("EXPRESS");
        printOddNumbersBelow(10);
        printCountdown(3);
        System.out.println("2024 is leap year: " + isLeapYear(2024));
        System.out.println("1900 is leap year: " + isLeapYear(1900));
    }

    /** if / else if / else chooses exactly one branch. */
    public static String gradeFor(int score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Score must be between 0 and 100");
        }
        if (score >= 90) {
            return "A";
        }
        if (score >= 75) {
            return "B";
        }
        if (score >= 60) {
            return "C";
        }
        return "Needs improvement";
    }

    /** switch is useful when one value has several fixed choices. */
    public static void printShippingMessage(String shippingType) {
        switch (shippingType) {
            case "STANDARD":
                System.out.println("Delivery in 5-7 business days.");
                break;
            case "EXPRESS":
                System.out.println("Delivery in 1-2 business days.");
                break;
            default:
                System.out.println("Unknown shipping option.");
        }
    }

    /** for-loop: use when the number of iterations is known. */
    public static void printOddNumbersBelow(int limit) {
        System.out.print("Odd numbers: ");
        for (int number = 0; number < limit; number++) {
            if (number % 2 == 0) {
                continue; // Skip even numbers and continue the loop.
            }
            System.out.print(number + " ");
        }
        System.out.println();
    }

    /** while-loop: use when the loop ends after a condition changes. */
    public static void printCountdown(int start) {
        System.out.print("Countdown: ");
        int current = start;
        while (current > 0) {
            System.out.print(current-- + " ");
        }
        System.out.println("go");
    }

    /** A real-world condition is clearer when it has a descriptive method name. */
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
}
