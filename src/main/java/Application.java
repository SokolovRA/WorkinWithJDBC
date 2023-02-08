import dao.CityDAO;
import dao.CityDAOImpl;
import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import model.City;
import model.Employee;

import java.sql.*;
import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException {

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        CityDAO cityDAO = new CityDAOImpl();

        City city1 = new City("Пятигорск");
        City city2 = new City(4,"Барнаул");
//        cityDAO.create(city1);
//        Employee employee1 = new Employee("Владимир","Смирнов","MAN",30);
//        City city2 = cityDAO.readById(7);
//        employee1.setCity(city2);
//        employeeDAO.create(employee1);
//        System.out.println(cityDAO.readById(7));
//        System.out.println(cityDAO.readAll());
//        cityDAO.update(city2);
          cityDAO.delete(cityDAO.readById(4));











//        Employee employee1 = new Employee("Лида", "Овчиникова", "WOMAN", 29, 4);
//
////        employeeDAO.create(employee1);
////        System.out.println(employeeDAO.readById(8));
////        List<Employee> employeeList = employeeDAO.readAll();
////        for (Employee employee : employeeList) {
////            System.out.println(employee);
//            Employee employee2 = new Employee(31, "Наталья", "Ворожбитова", "WOMAN", 34, 2);
////        employeeDAO.update(employee2);
////        employeeDAO.delete(employee2);
        }
    }


