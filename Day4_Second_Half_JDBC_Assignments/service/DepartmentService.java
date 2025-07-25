package Day4_Second_Half_JDBC_Assignment.service;



import java.util.List;

import Day4_Second_Half_JDBC_Assignment.exception.DepartmentNotFoundException;
import Day4_Second_Half_JDBC_Assignment.model.Department;
public class DepartmentService {
	 private DepartmentDAO dao = new DepartmentDAOImpl();

	    public void addDepartment(Department dept) {
	        dao.addDepartment(dept);
	    }

	    public Department getDepartmentById(int id) throws DepartmentNotFoundException {
	        return dao.getDepartmentById(id);
	    }

	    public List<Department> getAllDepartments() {
	        return dao.getAllDepartments();
	    }

	    public void updateDepartment(Department dept) throws DepartmentNotFoundException {
	        dao.updateDepartment(dept);
	    }

	    public void deleteDepartment(int id) throws DepartmentNotFoundException {
	        dao.deleteDepartment(id);
	    }
}
