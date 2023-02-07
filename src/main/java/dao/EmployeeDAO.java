package dao;
import model.Employee;
import java.util.List;

public interface EmployeeDAO {
    void create(Employee employee);

    Employee readById(int id);

    List<Employee> readAll();

    void update(int id,int city_id);

    void delete( int id );

}
