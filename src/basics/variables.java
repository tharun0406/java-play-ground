package basic;

public class Variables {
    public static void main(String[] args) {
        // ----- Variable Declarations and Initialization -----

        // Integer (whole number)
        int age = 25;
        System.out.println("Age: " + age);

        // Double (floating-point number)
        double height = 5.9;
        System.out.println("Height: " + height);

        // Character (single character)
        char grade = 'A';
        System.out.print("Alphabets : ");
        for(char i = grade;i<='Z';i++){
          System.out.print(i + " ");
        }
        System.out.println();
          
        // Boolean (true/false)
        boolean isJavaFun = true;
        System.out.println("Is Java fun? " + isJavaFun);

        // String (text, not a primitive type)
        String name = "Rajesh";
        System.out.println("Name: " + name);

        // ----- Variable Reassignment -----
        age = 26; // updating the value of age
        System.out.println("Updated Age: " + age);

        // ----- Final Variable (Constant) -----
        final double PI = 3.14159;
        System.out.println("Value of PI: " + PI);
        // PI = 3.14; // ❌ This will cause an error because PI is final (constant)

        // ----- Multiple Variables -----
        int x = 5, y = 10, z = 15;
        System.out.println("Sum: " + (x + y + z));

        // ----- Type Casting -----
        // Implicit Casting (smaller to larger type)
        int intVal = 100;
        double doubleVal = intVal;
        System.out.println("Implicit Casting (int to double): " + doubleVal);

        // Explicit Casting (larger to smaller type)
        double price = 99.99;
        int roundedPrice = (int) price;
        System.out.println("Explicit Casting (double to int): " + roundedPrice);
    }
}
