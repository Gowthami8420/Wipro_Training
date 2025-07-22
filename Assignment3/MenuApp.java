package Day2_First_Half_Assignment.Assignment3;

import java.util.Scanner;

public class MenuApp {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MathOperations math = new MathOperations();
        int choice;

        do {
            System.out.println("\n=== Math Operations Menu ===");
            System.out.println("1. Print Multiplication Table");
            System.out.println("2. Calculate Factorial");
            System.out.println("3. Check Prime Number");
            System.out.println("4. Print Fibonacci Series");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter a number: ");
                    int tableNum = scanner.nextInt();
                    math.printTable(tableNum);
                    break;

                case 2:
                    System.out.print("Enter a number: ");
                    int factNum = scanner.nextInt();
                    math.calculateFactorial(factNum);
                    break;

                case 3:
                    System.out.print("Enter a number: ");
                    int primeNum = scanner.nextInt();
                    math.checkPrime(primeNum);
                    break;

                case 4:
                    System.out.print("Enter number of terms: ");
                    int terms = scanner.nextInt();
                    math.printFibonacci(terms);
                    break;

                case 5:
                    System.out.println("Exiting the program!");
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }

        } while (choice != 5);

        scanner.close();
    }
}
