import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import model.City;
import model.Employee;

import java.sql.*;
import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException {

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();

        Employee employee1 = new Employee("Лида", "Овчиникова", "WOMAN", 29, 4);

//        employeeDAO.create(employee1);
//        System.out.println(employeeDAO.readById(8));
//        List<Employee> employeeList = employeeDAO.readAll();
//        for (Employee employee : employeeList) {
//            System.out.println(employee);
            Employee employee2 = new Employee(31, "Наталья", "Ворожбитова", "WOMAN", 34, 2);
//        employeeDAO.update(employee2);
//        employeeDAO.delete(employee2);
        }
    }


