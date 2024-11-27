class StudentStack {
    private Node top = null;
    private int size = 0;

    public StudentStack() {
    }

    public void push(Student student) {
        Node newNode = new Node(student);
        newNode.next = this.top;
        this.top = newNode;
        ++this.size;
        System.out.println("Inserted: " + student);
    }

    public Student pop() {
        if (this.isEmpty()) {
            System.out.println("Stack Underflow! No students to remove.");
            return null;
        } else {
            Student poppedStudent = this.top.student;
            this.top = this.top.next;
            --this.size;
            return poppedStudent;
        }
    }

    public Student peek() {
        if (this.isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        } else {
            return this.top.student;
        }
    }

    public boolean isEmpty() {
        return this.top == null;
    }

    public int size() {
        return this.size;
    }

    public void displayStudents() {
        if (this.isEmpty()) {
            System.out.println("No students in the stack.");
        } else {
            System.out.println("Students in Stack:");

            for(Node current = this.top; current != null; current = current.next) {
                System.out.println(current.student);
            }

        }
    }

    public void updateStudent(int id, String newName, double newGrade) {
        Node current = this.top;

        boolean found;
        for(found = false; current != null; current = current.next) {
            if (current.student.getId() == id) {
                current.student = new Student(id, newName, newGrade);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student with ID " + id + " not found.");
        }

    }

    public Student searchStudent(int id) {
        for(Node current = this.top; current != null; current = current.next) {
            if (current.student.getId() == id) {
                return current.student;
            }
        }

        return null;
    }

    public void deleteStudent(int id) {
        Node current = this.top;

        for(Node previous = null; current != null; current = current.next) {
            if (current.student.getId() == id) {
                if (previous == null) {
                    this.top = current.next;
                } else {
                    previous.next = current.next;
                }

                --this.size;
                System.out.println("Deleted student with ID " + id);
                return;
            }

            previous = current;
        }

        System.out.println("Student with ID " + id + " not found.");
    }

    private class Node {
        Student student;
        Node next;

        Node(Student student) {
            this.student = student;
            this.next = null;
        }
    }
}