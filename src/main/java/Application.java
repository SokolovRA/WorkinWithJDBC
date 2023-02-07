import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import model.City;
import model.Employee;

import java.sql.*;

public class Application {
    public static void main(String[] args) throws SQLException {

        final String user = "postgres";
        final String password = "162400";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(" SELECT * FROM employee " +
                     "RIGHT JOIN city ON employee.city_id = city.city_id " +
                     " WHERE id = (?) ")) {

            statement.setInt(1, 2);

            final ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                String first_name = "First_name: " + resultSet.getString("first_name");
                String last_name = "Last_name: " + resultSet.getString("last_name");
                String gender = "Gender: " + resultSet.getString("gender");
                String city_name = "City_name:  " + resultSet.getString("city_name");

                System.out.println(first_name);
                System.out.println(last_name);
                System.out.println(gender);
                System.out.println(city_name);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //Задача2
        try (Connection connection = DriverManager.getConnection(url, user, password)) {

            EmployeeDAO employeeDAO = new EmployeeDAOImpl(connection);

            City city1 = new City(6," Нефтеструйск " );
            Employee employee1 = new Employee("Леня", "Филатов", "MAN", 33, city1);

//            employeeDAO.create(employee1);

//             System.out.println(employeeDAO.readById(11));
//             System.out.println(employeeDAO.readAll());
//             employeeDAO.update(3,2);
//             employeeDAO.delete(28);
//             employeeDAO.delete(12);
//             employeeDAO.delete(18);
//             employeeDAO.delete(19);
//             employeeDAO.delete(21);
//             employeeDAO.delete(22);
//             employeeDAO.delete(25);
//             employeeDAO.delete(26);
//             employeeDAO.delete(27);

            System.out.println(employeeDAO.readAll());

        }
    }
}
