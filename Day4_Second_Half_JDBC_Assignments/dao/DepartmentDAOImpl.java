package Day4_Second_Half_JDBC_Assignment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Day4_Second_Half_JDBC_Assignment.exception.DepartmentNotFoundException; 

import Day4_Second_Half_JDBC_Assignment.model.Department;
import Day4_Second_Half_JDBC_Assignment.util.DBUtil;

public class DepartmentDAOImpl {
	 public void addDepartment(Department dept) {
	        String query = "INSERT INTO department (deptId, deptName, location) VALUES (?, ?, ?)";
	        try (Connection conn = DBUtil.getConnection();
	             PreparedStatement ps = conn.prepareStatement(query)) {

	            ps.setInt(1, dept.getDeptId());
	            ps.setString(2, dept.getDeptName());
	            ps.setString(3, dept.getLocation());
	            ps.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public Department getDepartmentById(int id) throws DepartmentNotFoundException {
	        String query = "SELECT * FROM department WHERE deptId = ?";
	        try (Connection conn = DBUtil.getConnection();
	             PreparedStatement ps = conn.prepareStatement(query)) {

	            ps.setInt(1, id);
	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {
	                return new Department(rs.getInt("deptId"), rs.getString("deptName"), rs.getString("location"));
	            } else {
	                throw new DepartmentNotFoundException("Department with ID " + id + " not found.");
	            }
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	    }

	    public List<Department> getAllDepartments() {
	        List<Department> list = new ArrayList<>();
	        String query = "SELECT * FROM department";
	        try (Connection conn = DBUtil.getConnection();
	             PreparedStatement ps = conn.prepareStatement(query);
	             ResultSet rs = ps.executeQuery()) {

	            while (rs.next()) {
	                list.add(new Department(rs.getInt("deptId"), rs.getString("deptName"), rs.getString("location")));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return list;
	    }

	    public void updateDepartment(Department dept) throws DepartmentNotFoundException {
	        String query = "UPDATE department SET deptName = ?, location = ? WHERE deptId = ?";
	        try (Connection conn = DBUtil.getConnection();
	             PreparedStatement ps = conn.prepareStatement(query)) {

	            ps.setString(1, dept.getDeptName());
	            ps.setString(2, dept.getLocation());
	            ps.setInt(3, dept.getDeptId());

	            int rows = ps.executeUpdate();
	            if (rows == 0) {
	                throw new DepartmentNotFoundException("No department found with ID: " + dept.getDeptId());
	            }
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	    }

	    public void deleteDepartment(int id) throws DepartmentNotFoundException {
	        String query = "DELETE FROM department WHERE deptId = ?";
	        try (Connection conn = DBUtil.getConnection();
	             PreparedStatement ps = conn.prepareStatement(query)) {

	            ps.setInt(1, id);
	            int rows = ps.executeUpdate();
	            if (rows == 0) {
	                throw new DepartmentNotFoundException("Department with ID " + id + " does not exist.");
	            }
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	    }
}
