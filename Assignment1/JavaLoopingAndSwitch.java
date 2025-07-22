package Day2_First_Half_Assignment.Assignment1;

import java.util.Scanner;

public class JavaLoopingAndSwitch {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int choice = 0;

	        while (true) {
	            System.out.println("********** MENU **********");
	            System.out.println("1. Print Table of a Number");
	            System.out.println("2. Calculate Factorial");
	            System.out.println("3. Check Prime Number");
	            System.out.println("4. Print Fibonacci Series");
	            System.out.println("5. Exit");
	            System.out.println("**************************");
	            System.out.print("Enter your choice: ");

	            if (sc.hasNextInt()) {
	                choice = sc.nextInt();
	            } else {
	                System.out.println("Invalid input. Please enter a number.");
	                sc.next(); 
	                continue;
	            }

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter the number: ");
	                    int num = sc.nextInt();
	                    for (int i = 1; i <= 10; i++) {
	                        System.out.println(num + " x " + i + " = " + (num * i));
	                    }
	                    break;

	                case 2:
	                    System.out.print("Enter the number: ");
	                    int fact = sc.nextInt();
	                    if (fact < 0) {
	                        System.out.println("Factorial is not defined for negative numbers.");
	                        break;
	                    }
	                    long result = 1;
	                    for (int i = 1; i <= fact; i++) {
	                        result *= i;
	                    }
	                    System.out.println("Factorial of " + fact + " is " + result);
	                    break;

	                case 3:
	                    System.out.print("Enter the number: ");
	                    int prime = sc.nextInt();
	                    boolean isPrime = true;
	                    if (prime <= 1) {
	                        isPrime = false;
	                    } else {
	                        for (int i = 2; i <= Math.sqrt(prime); i++) {
	                            if (prime % i == 0) {
	                                isPrime = false;
	                                break;
	                            }
	                        }
	                    }
	                    if (isPrime) {
	                        System.out.println(prime + " is a prime number.");
	                    } else {
	                        System.out.println(prime + " is not a prime number.");
	                    }
	                    break;

	                case 4:
	                    System.out.print("Enter the number of terms: ");
	                    int terms = sc.nextInt();
	                    if (terms <= 0) {
	                        System.out.println("Please enter a positive number.");
	                        break;
	                    }
	                    int a = 0, b = 1;
	                    System.out.print("Fibonacci Series: ");
	                    for (int j = 1; j <= terms; j++) {
	                        System.out.print(a + " ");
	                        int next = a + b;
	                        a = b;
	                        b = next;
	                    }
	                    System.out.println();
	                    break;

	                case 5:
	                    System.out.println("Exiting program.");
	                    sc.close();
	                    return;

	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }

	            System.out.println("\nPress Enter to Y to Continue...");
	            sc.nextLine(); 
	        }
	    }
}
