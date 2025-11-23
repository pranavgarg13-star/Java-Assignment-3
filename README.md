Java-Assignment

By : Pranav Garg ,
Roll No. : 2401010034

Student Result Management System


This is a simple menu-driven Java application that manages student records, validates marks using custom exceptions, and displays results based on average marks.


📌 Features

Add new student details

Enter and validate marks (0–100)

Custom exception handling (InvalidMarksException)

Calculate average marks

Display student information and pass/fail status

Search student using roll number

Input validation using try-catch and InputMismatchException

Simple, clean menu interface

📁 File Contains

InvalidMarksException – Custom exception for invalid marks

Student – Class that stores student details and performs validation

StudentResultManager – Menu-driven controller class

📝 How to Run

Compile the Java program

javac StudentResultManager.java


Run the program

java StudentResultManager

💻 Sample Interaction
===== Student Result Management System =====
1. Add Student
2. Show Student Details
3. Exit
Enter your choice: 1

Enter Roll Number: 101
Enter Student Name: Rohan
Enter marks for subject 1: 85
Enter marks for subject 2: 78
Enter marks for subject 3: 92
Student added successfully. Returning to main menu...

===== Student Result Management System =====
1. Add Student
2. Show Student Details
3. Exit
Enter your choice: 2

Enter Roll Number to search: 101
Roll Number: 101
Student Name: Rohan
Marks: 85 78 92
Average: 85.0
Result: Pass
