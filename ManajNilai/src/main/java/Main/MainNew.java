package Main;
import Main.*;

import java.util.Scanner;

public class MainNew {

    private ManajemenNew manajemen;

    public MainNew() {
        this.manajemen = new ManajemenNew();
    }

    // Method to add a student
    public void addStudent(String nama, String nis, String kelas) {
        manajemen.tambahSiswa(nama, nis, kelas);
    }

    // Method to edit a student's details
    public void editStudent(int id, String nama, String nis, String kelas) {
        manajemen.editSiswa(id, nama, nis, kelas);
    }

    // Method to delete a student
    public void deleteStudent(int id) {
        manajemen.hapusSiswa(id);
    }

    // Method to add grades to a student
    public void addGrades(int id, double nilai1, double nilai2, double nilai3) {
        manajemen.inputNilai(id, nilai1, nilai2, nilai3);
    }

    // Method to edit grades of a student
    public void editGrades(int id, double nilai1, double nilai2, double nilai3) {
        manajemen.editNilai(id, nilai1, nilai2, nilai3);
    }

    // Getter for ManajemenNew instance
    public ManajemenNew getManajemen() {
        return manajemen;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MainNew app = new MainNew();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Add Grades");
            System.out.println("5. Edit Grades");
            System.out.println("6. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter NIS: ");
                    String nis = scanner.nextLine();
                    System.out.print("Enter class: ");
                    String kelas = scanner.nextLine();
                    app.addStudent(name, nis, kelas);
                    break;

                case 2:
                    System.out.print("Enter student ID to edit: ");
                    int editId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new NIS: ");
                    String newNis = scanner.nextLine();
                    System.out.print("Enter new class: ");
                    String newKelas = scanner.nextLine();
                    app.editStudent(editId, newName, newNis, newKelas);
                    break;

                case 3:
                    System.out.print("Enter student ID to delete: ");
                    int deleteId = scanner.nextInt();
                    app.deleteStudent(deleteId);
                    break;

                case 4:
                    System.out.print("Enter student ID for grades: ");
                    int gradeId = scanner.nextInt();
                    System.out.print("Enter grade 1: ");
                    double grade1 = scanner.nextDouble();
                    System.out.print("Enter grade 2: ");
                    double grade2 = scanner.nextDouble();
                    System.out.print("Enter grade 3: ");
                    double grade3 = scanner.nextDouble();
                    app.addGrades(gradeId, grade1, grade2, grade3);
                    break;

                case 5:
                    System.out.print("Enter student ID to edit grades: ");
                    int editGradeId = scanner.nextInt();
                    System.out.print("Enter new grade 1: ");
                    double newGrade1 = scanner.nextDouble();
                    System.out.print("Enter new grade 2: ");
                    double newGrade2 = scanner.nextDouble();
                    System.out.print("Enter new grade 3: ");
                    double newGrade3 = scanner.nextDouble();
                    app.editGrades(editGradeId, newGrade1, newGrade2, newGrade3);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}