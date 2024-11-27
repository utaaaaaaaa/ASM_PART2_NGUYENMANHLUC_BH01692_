import java.util.Stack;

class StudentManagement {
    private Stack<Student> students = new Stack();

    public StudentManagement() {
    }

    public void addStudent(Student student) {
        this.students.push(student);
    }

    public void updateStudent(int id, String newName, double newGrade) {
        Stack<Student> tempStack = new Stack();
        boolean found = false;

        while(!this.students.isEmpty()) {
            Student student = (Student)this.students.pop();
            if (student.getId() == id) {
                tempStack.push(new Student(id, newName, newGrade));
                found = true;
            } else {
                tempStack.push(student);
            }
        }

        while(!tempStack.isEmpty()) {
            this.students.push((Student)tempStack.pop());
        }

        if (!found) {
            System.out.println("Student with ID " + id + " not found.");
        }

    }

    public void deleteStudent(int id) {
        Stack<Student> tempStack = new Stack();

        while(!this.students.isEmpty()) {
            Student student = (Student)this.students.pop();
            if (student.getId() != id) {
                tempStack.push(student);
            }
        }

        while(!tempStack.isEmpty()) {
            this.students.push((Student)tempStack.pop());
        }

    }

    public Student searchStudent(int id) {
        for(Student student : this.students) {
            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }

    public void displayStudents() {
        Stack<Student> tempStack = new Stack();

        while(!this.students.isEmpty()) {
            Student student = (Student)this.students.pop();
            System.out.println(student);
            tempStack.push(student);
        }

        while(!tempStack.isEmpty()) {
            this.students.push((Student)tempStack.pop());
        }

    }
}
