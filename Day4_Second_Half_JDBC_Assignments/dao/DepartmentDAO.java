package Day4_Second_Half_JDBC_Assignment.dao;

import java.util.List;
import Day4_Second_Half_JDBC_Assignment.exception.DepartmentNotFoundException;
import Day4_Second_Half_JDBC_Assignment.model.Department;

public interface DepartmentDAO {
    void addDepartment(Department dept);
    Department getDepartmentById(int id) throws DepartmentNotFoundException;
    List<Department> getAllDepartments();
    void updateDepartment(Department dept) throws DepartmentNotFoundException;
    void deleteDepartment(int id) throws DepartmentNotFoundException;
}
