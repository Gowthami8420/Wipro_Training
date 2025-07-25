package Day4_Second_Half_JDBC_Assignment.client;
import java.util.List;
import java.util.Scanner;

import Day4_Second_Half_JDBC_Assignment.dao.DepartmentService;
import Day4_Second_Half_JDBC_Assignment.exception.DepartmentNotFoundException;
import Day4_Second_Half_JDBC_Assignment.model.Department;
public class DepartmentClient {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        DepartmentService service = new DepartmentService();
	        int choice;

	        do {
	            System.out.println("\n--- Department Management ---");
	            System.out.println("1. Add Department");
	            System.out.println("2. Get Department by ID");
	            System.out.println("3. Get All Departments");
	            System.out.println("4. Update Department");
	            System.out.println("5. Delete Department");
	            System.out.println("0. Exit");
	            System.out.print("Enter choice: ");
	            choice = sc.nextInt();

	            try {
	                switch (choice) {
	                    case 1:
	                        System.out.print("Enter ID: ");
	                        int id = sc.nextInt();
	                        sc.nextLine();
	                        System.out.print("Enter Name: ");
	                        String name = sc.nextLine();
	                        System.out.print("Enter Location: ");
	                        String location = sc.nextLine();
	                        service.addDepartment(new Department(id, name, location));
	                        System.out.println("Added successfully.");
	                        break;

	                    case 2:
	                        System.out.print("Enter Department ID: ");
	                        int getId = sc.nextInt();
	                        Department dept = service.getDepartmentById(getId);
	                        System.out.println(dept);
	                        break;

	                    case 3:
	                        List<Department> all = service.getAllDepartments();
	                        all.forEach(System.out::println);
	                        break;

	                    case 4:
	                        System.out.print("Enter ID to update: ");
	                        int upId = sc.nextInt();
	                        sc.nextLine();
	                        System.out.print("Enter new Name: ");
	                        String newName = sc.nextLine();
	                        System.out.print("Enter new Location: ");
	                        String newLocation = sc.nextLine();
	                        service.updateDepartment(new Department(upId, newName, newLocation));
	                        System.out.println("Updated successfully.");
	                        break;

	                    case 5:
	                        System.out.print("Enter ID to delete: ");
	                        int delId = sc.nextInt();
	                        service.deleteDepartment(delId);
	                        System.out.println("Deleted successfully.");
	                        break;

	                    case 0:
	                        System.out.println("Exiting...");
	                        break;

	                    default:
	                        System.out.println("Invalid choice.");
	                }
	            } catch (DepartmentNotFoundException e) {
	                System.out.println("ERROR: " + e.getMessage());
	            }
	        } while (choice != 0);
	        sc.close();
	    }
}
