

/**
 * Inheritance lets a specialised class reuse and extend a parent class.
 * Developer inherits common employee data from Employee, calls the parent
 * constructor with super(...), and overrides work().
 */
public class Inheritance {

    private static class Employee {
        private final String name;
        private final double monthlySalary;

        Employee(String name, double monthlySalary) {
            this.name = name;
            this.monthlySalary = monthlySalary;
        }

        public String getName() {
            return name;
        }

        public double annualSalary() {
            return monthlySalary * 12;
        }

        public String work() {
            return name + " completes general employee tasks.";
        }
    }

    private static class Developer extends Employee {
        private final String primaryLanguage;

        Developer(String name, double monthlySalary, String primaryLanguage) {
            super(name, monthlySalary); // Initialise fields owned by Employee.
            this.primaryLanguage = primaryLanguage;
        }

        @Override
        public String work() {
            return getName() + " writes " + primaryLanguage + " code.";
        }

        public String getPrimaryLanguage() {
            return primaryLanguage;
        }
    }

    public static void main(String[] args) {
        Employee employee = new Employee("Asha", 50_000);
        Developer developer = new Developer("Tharun", 75_000, "Java");

        System.out.println(employee.work());
        System.out.println(developer.work());
        System.out.println(developer.getName() + " annual salary: "
                + developer.annualSalary());
        System.out.println("Primary language: " + developer.getPrimaryLanguage());
    }
}
