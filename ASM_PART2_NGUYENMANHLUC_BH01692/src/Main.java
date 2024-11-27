public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        StudentStack studentStack = new StudentStack();
        Student student1 = new Student(1, "Alice", (double)8.5F);
        Student student2 = new Student(2, "Bob", (double)6.0F);
        Student student3 = new Student(3, "Charlie", 9.2);
        studentStack.push(student1);
        studentStack.push(student2);
        studentStack.push(student3);
        studentStack.displayStudents();
        studentStack.updateStudent(2, "Bob Smith", (double)7.5F);
        Student foundStudent = studentStack.searchStudent(2);
        System.out.println("Found Student: " + foundStudent);
        Student poppedStudent = studentStack.pop();
        System.out.println("Popped Student: " + poppedStudent);
        studentStack.displayStudents();
        studentStack.deleteStudent(1);
        studentStack.displayStudents();
    }
}
