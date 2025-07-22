package Day2_First_Half_Assignment.Assignment2;

import java.util.Scanner;

public class StringAssignmentApp {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringUtility util = new StringUtility();

        System.out.print("Enter a string: ");
        String inputStr = scanner.nextLine();

        int choice;
        do {
            System.out.println("\n--- String Operations Menu ---");
            System.out.println("1. Count Vowels and Consonants");
            System.out.println("2. Check if Palindrome");
            System.out.println("3. Reverse String");
            System.out.println("4. Convert to Uppercase");
            System.out.println("5. Convert to Lowercase");
            System.out.println("6. Replace Word");
            System.out.println("7. Exit");
            System.out.print("Enter your choice (1-7): ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    int vowels = util.countVowels(inputStr);
                    int consonants = util.countConsonants(inputStr);
                    System.out.println("Vowels: " + vowels);
                    System.out.println("Consonants: " + consonants);
                    break;

                case 2:
                    boolean isPalin = util.isPalindrome(inputStr);
                    System.out.println("Is Palindrome: " + isPalin);
                    break;

                case 3:
                    System.out.println("Reversed String: " + util.reverseString(inputStr));
                    break;

                case 4:
                    System.out.println("Uppercase: " + util.toUpperCase(inputStr));
                    break;

                case 5:
                    System.out.println("Lowercase: " + util.toLowerCase(inputStr));
                    break;

                case 6:
                    System.out.print("Enter word to replace: ");
                    String oldWord = scanner.nextLine();
                    System.out.print("Enter new word: ");
                    String newWord = scanner.nextLine();
                    inputStr = util.replaceWord(inputStr, oldWord, newWord);
                    System.out.println("Updated String: " + inputStr);
                    break;

                case 7:
                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Invalid choice! Please choose from 1 to 7.");
            }

        } while (choice != 7);

        scanner.close();
    }
}
