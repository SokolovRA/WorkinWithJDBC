package dao;

import model.City;
import model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private Connection connection;

    public EmployeeDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Employee employee) {
        try(PreparedStatement statement = connection.prepareStatement(" INSERT INTO employee (first_name,last_name,gender,age,city_id )" +
                "VALUES ((?),(?),(?),(?),(?)) ")) {

            statement.setString(1, employee.getFirst_name());
            statement.setString(2,employee.getLast_name());
            statement.setString(3,employee.getGender());
            statement.setInt(4, employee.getAge());
            statement.setInt(5, employee.getCity().getCity_id());

            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee readById(int id) {
        Employee employee = new Employee();
        try (PreparedStatement statement = connection.prepareStatement(
          "SELECT * FROM employee"+
            " JOIN city ON employee.city_id=city.city_id"+
              " AND employee.id=(?)")) {

                statement.setInt(1, id);

                ResultSet resultSet = statement.executeQuery();

                while(resultSet.next()) {

                    employee.setId(Integer.parseInt(resultSet.getString("id")));
                    employee.setFirst_name(resultSet.getString("first_name"));
                    employee.setLast_name(resultSet.getString("last_name"));
                    employee.setGender(resultSet.getString("gender"));
                    employee.setAge(resultSet.getInt("age"));
                    employee.setCity(new City(resultSet.getInt("city_id"),
                            resultSet.getString("city_name")));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return employee;
    }


    @Override
    public List<Employee> readAll() {

        List<Employee> employeeList = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM employee"+
                        " JOIN city ON employee.city_id = city.city_id")) {

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {

                int id= Integer.parseInt(resultSet.getString("id"));
                String first_name = resultSet.getString("first_name");
                String last_name = (resultSet.getString("last_name"));
                String gender = resultSet.getString("gender");
                int age = resultSet.getInt("age");
                City city = new City(resultSet.getInt("city_id"),
                        resultSet.getString("city_name"));

                employeeList.add(new Employee(id, first_name, last_name, gender,age,city));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public void update(int id,int city_id) {
        try (PreparedStatement statement = connection.prepareStatement(
                "UPDATE employee SET city_id = (?) WHERE id = (?)")) {
            statement.setInt(1, city_id);
            statement.setInt(2, id);

            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void delete(int id) {
        try (PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM employee WHERE id = (?)")) {
            statement.setInt(1, id);

            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


