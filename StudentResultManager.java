import java.util.InputMismatchException;
import java.util.Scanner;

// Custom Exception Class to handle invalid marks
class InvalidMarksException extends Exception {
    public InvalidMarksException(String message) {
        super(message);
    }
}

// Student Class to store student details and marks
class Student {
    private int rollNumber;              // Unique roll number
    private String studentName;          // Student name
    private int[] marks = new int[3];    // Marks of 3 subjects

    // Constructor to initialize student attributes
    public Student(int rollNumber, String studentName, int[] marks) {
        this.rollNumber = rollNumber;
        this.studentName = studentName;
        this.marks = marks;
    }

    // Method to validate marks between 0 and 100
    public void validateMarks() throws InvalidMarksException {
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] < 0 || marks[i] > 100) {
                throw new InvalidMarksException(
                    "Invalid marks for subject " + (i + 1) + ": " + marks[i]
                );
            }
        }
    }

    // Method to calculate average marks
    public double calculateAverage() {
        int sum = 0;
        for (int m : marks) sum += m;
        return sum / 3.0;
    }

    // Method to display student details and result
    public void displayResult() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Student Name: " + studentName);
        System.out.print("Marks: ");
        for (int m : marks) System.out.print(m + " ");
        System.out.println();

        double avg = calculateAverage();
        System.out.println("Average: " + avg);

        // Simple pass/fail condition
        if (avg >= 40) System.out.println("Result: Pass");
        else System.out.println("Result: Fail");
    }

    public int getRollNumber() {
        return rollNumber;
    }
}

// Main Manager Class to handle UI and student operations
public class StudentResultManager {

    private Student[] students = new Student[100]; // Array to store students
    private int count = 0;                        // Student counter
    private Scanner sc = new Scanner(System.in);  // Scanner for input

    // Method to add a new student
    public void addStudent() {
        try {
            System.out.print("Enter Roll Number: ");
            int roll = sc.nextInt();
            sc.nextLine(); // Consume newline

            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            int[] marks = new int[3];

            // Input marks for 3 subjects
            for (int i = 0; i < 3; i++) {
                System.out.print("Enter marks for subject " + (i + 1) + ": ");
                marks[i] = sc.nextInt();
            }

            // Create student object
            Student s = new Student(roll, name, marks);

            // Validate marks (may throw custom exception)
            s.validateMarks();

            // Add to array
            students[count++] = s;
            System.out.println("Student added successfully. Returning to main menu...
");

        } catch (InvalidMarksException e) {
            // Catch custom exception
            System.out.println("Error: " + e.getMessage());
        } catch (InputMismatchException e) {
            // Catch input mismatch exception
            System.out.println("Error: Input mismatch. Please enter valid numeric values.");
            sc.nextLine(); // Clear buffer
        }
    }

    // Method to search and display details of a specific student
    public void showStudentDetails() {
        try {
            System.out.print("Enter Roll Number to search: ");
            int roll = sc.nextInt();

            boolean found = false;

            // Search for student in array
            for (int i = 0; i < count; i++) {
                if (students[i].getRollNumber() == roll) {
                    students[i].displayResult();
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Student not found.");
            }

            System.out.println("Search completed.
");

        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input type.");
            sc.nextLine();
        }
    }

    // Main menu loop
    public void mainMenu() {
        try {
            int choice;
            do {
                System.out.println("===== Student Result Management System =====");
                System.out.println("1. Add Student");
                System.out.println("2. Show Student Details");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");

                choice = sc.nextInt();

                // Handle menu options
                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        showStudentDetails();
                        break;
                    case 3:
                        System.out.println("Exiting program. Thank you!");
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }

            } while (choice != 3);

        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid menu choice.");
        } finally {
            // finally block always runs
            System.out.println("Closing Scanner...");
            sc.close();
        }
    }

    
    public static void main(String[] args) {
        StudentResultManager manager = new StudentResultManager();
        manager.mainMenu();
    }
}
