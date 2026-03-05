import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeService {

    private final List<Employee> employees;

    public EmployeeService(List<Employee> employees) {
        this.employees = employees;
    }

    public Optional<Employee> findEmployeeById(int id) {
        return employees.stream()
                .filter(e -> e.getId() == id)
                .findFirst();
    }

    public List<Employee> getEmployeesByDepartment(String department) {
        return employees.stream()
                .filter(e -> e.getDepartment().equalsIgnoreCase(department))
                .collect(Collectors.toList());
    }

    public List<Employee> getHighSalaryEmployees(double salary) {
        return employees.stream()
                .filter(e -> e.getSalary() > salary)
                .collect(Collectors.toList());
    }

    public double getAverageSalary() {
        return employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);
    }
}