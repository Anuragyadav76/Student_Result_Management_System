package org.example;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DatabaseManager db = new DatabaseManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Student Result Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter course: ");
                    String course = sc.nextLine();

                    Student st = new Student(name, course);
                    db.addStudent(st);
                    break;

                case 2:
                    System.out.println("\nAll Students:");
                    db.getAllStudents().forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Enter ID to update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter new course: ");
                    String newCourse = sc.nextLine();

                    db.updateStudent(uid, newName, newCourse);
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    int did = sc.nextInt();
                    db.deleteStudent(did);
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}