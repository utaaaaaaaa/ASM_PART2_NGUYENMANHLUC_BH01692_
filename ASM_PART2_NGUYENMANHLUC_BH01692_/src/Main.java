import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentStack studentStack = new StudentStack();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Display Students");
            System.out.println("5. Search Student");
            System.out.println("6. Pop Student");
            System.out.println("7. Sort Students (Bubble Sort)");
            System.out.println("8. Sort Students (Merge Sort)"); // New option for Merge Sort
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            generateRandomStudents(studentStack, 1000);
            StudentStack temp1 = studentStack;
            StudentStack temp2 =studentStack;
            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Student Grade: ");
                    double grade = scanner.nextDouble();
                    studentStack.push(new Student(id, name, grade));
                    break;
                case 2:
                    System.out.print("Enter Student ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new Student Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new Student Grade: ");
                    double newGrade = scanner.nextDouble();
                    studentStack.updateStudent(updateId, newName, newGrade);
                    break;
                case 3:
                    System.out.print("Enter Student ID to delete: ");
                    int deleteId = scanner.nextInt();
                    studentStack.deleteStudent(deleteId);
                    break;
                case 4:
                    studentStack.displayStudents();
                    break;
                case 5:
                    System.out.print("Enter Student ID to search: ");
                    int searchId = scanner.nextInt();
                    Student foundStudent = studentStack.searchStudent(searchId);
                    System.out.println("Found Student: " + (foundStudent != null ? foundStudent : "Not found"));
                    break;
                case 6:
                    Student poppedStudent = studentStack.pop();
                    System.out.println("Popped Student: " + (poppedStudent != null ? poppedStudent : "No student to pop"));
                    break;
                case 7:
                    long duration = bubbleSort(studentStack);
                    System.out.println("Time taken to sort " + " students: " + duration + " nanoseconds");
                    break;
                case 8: // Merge Sort option
                    Student[] studentsArray = temp1.toArray(); // Convert stack to array

                    long duration2 = mergeSort(studentsArray); // Sort using merge sort
                    System.out.println("Time taken to sort " +" students: " + duration2 + " nanoseconds");
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void generateRandomStudents(StudentStack studentStack, int count) {
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int id = i + 1; // Unique ID
            String name = "Student" + id; // Simple name generation
            double grade = 0 + (10 - 0) * random.nextDouble(); // Random grade between 0 and 10
            studentStack.push(new Student(id, name, grade));
        }
    }

    private static long bubbleSort(StudentStack studentStack) {
        // Convert stack to array for sorting
        Student[] studentsArray = studentStack.toArray(); // Use toArray() method

        // Measure time taken for sorting
        long startTime = System.nanoTime();

        // Bubble Sort Algorithm
        int n = studentsArray.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (studentsArray[j].getGrade() > studentsArray[j + 1].getGrade()) {
                    // Swap students
                    Student temp = studentsArray[j];
                    studentsArray[j] = studentsArray[j + 1];
                    studentsArray[j + 1] = temp;
                }
            }
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime; // Duration in nanoseconds

        return duration;
    }

    private static long mergeSort(Student[] studentsArray) {
        long startTime = System.nanoTime();
        mergeSortHelper(studentsArray, 0, studentsArray.length - 1);
        long endTime = System.nanoTime();
        return endTime - startTime; // Duration in nanoseconds
    }

    private static void mergeSortHelper(Student[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // Sort the left half
            mergeSortHelper(array, left, mid);
            // Sort the right half
            mergeSortHelper(array, mid + 1, right);
            // Merge the sorted halves
            merge(array, left, mid, right);
        }
    }

    private static void merge(Student[] array, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays
        Student[] L = new Student[n1];
        Student[] R = new Student[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++)
            L[i] = array[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = array[mid + 1 + j];

        // Merge the temporary arrays
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i].getGrade() <= R[j].getGrade()) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }
}