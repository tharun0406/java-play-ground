

import java.util.Arrays;
import java.util.List;

/**
 * Polymorphism means one parent type can represent many concrete object types.
 * Calling area() on Shape uses runtime dispatch: Java chooses the overridden
 * implementation belonging to the actual object.
 */
public class Polymorphism {

    private abstract static class Shape {
        private final String name;

        Shape(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public abstract double area();
    }

    private static class Circle extends Shape {
        private final double radius;

        Circle(double radius) {
            super("Circle");
            this.radius = radius;
        }

        @Override
        public double area() {
            return Math.PI * radius * radius;
        }
    }

    private static class Rectangle extends Shape {
        private final double width;
        private final double height;

        Rectangle(double width, double height) {
            super("Rectangle");
            this.width = width;
            this.height = height;
        }

        @Override
        public double area() {
            return width * height;
        }
    }

    /** Method overloading is compile-time polymorphism. */
    private static String describeArea(int area) {
        return "Whole-number area: " + area;
    }

    private static String describeArea(double area) {
        return String.format("Decimal area: %.2f", area);
    }

    public static void main(String[] args) {
        List<Shape> shapes = Arrays.asList(new Circle(3), new Rectangle(4, 5));

        for (Shape shape : shapes) {
            System.out.println(shape.getName() + " -> " + describeArea(shape.area()));
        }

        System.out.println(describeArea(25));
    }
}
