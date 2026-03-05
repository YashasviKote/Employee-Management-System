import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(1, "Ravi", "IT", 70000),
                new Employee(2, "Anita", "HR", 50000),
                new Employee(3, "Kiran", "IT", 80000),
                new Employee(4, "Meena", "Finance", 60000)
        );

        EmployeeService service = new EmployeeService(employees);

        service.findEmployeeById(1)
                .ifPresent(System.out::println);

        System.out.println("\nIT Employees:");
        service.getEmployeesByDepartment("IT")
                .forEach(System.out::println);

        System.out.println("\nHigh Salary Employees:");
        service.getHighSalaryEmployees(65000)
                .forEach(System.out::println);

        System.out.println("\nAverage Salary: " + service.getAverageSalary());
    }
}