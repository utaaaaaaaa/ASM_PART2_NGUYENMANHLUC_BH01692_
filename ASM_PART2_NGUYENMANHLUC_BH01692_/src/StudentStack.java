class StudentStack {
    private Node top = null;
    private int size = 0;

    public void push(Student student) {
        Node newNode = new Node(student);
        newNode.next = this.top;
        this.top = newNode;
        size++;
        System.out.println("Inserted: " + student);
    }

    public Student pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! No students to remove.");
            return null;
        } else {
            Student poppedStudent = this.top.student;
            this.top = this.top.next;
            size--;
            return poppedStudent;
        }
    }

    public boolean isEmpty() {
        return this.top == null;
    }

    public int getSize() { // New method to get the size
        return this.size;
    }

    public Student[] toArray() { // New method to convert stack to array
        Student[] studentsArray = new Student[size];
        Node current = top;
        int index = 0;

        while (current != null) {
            studentsArray[index++] = current.student;
            current = current.next;
        }
        return studentsArray;
    }

    public void displayStudents() {
        if (isEmpty()) {
            System.out.println("No students in the stack.");
        } else {
            System.out.println("Students in Stack:");
            Node current = this.top;
            while (current != null) {
                System.out.println(current.student);
                current = current.next;
            }
        }
    }

    public void updateStudent(int id, String newName, double newGrade) {
        Node current = this.top;
        boolean found = false;

        while (current != null) {
            if (current.student.getId() == id) {
                current.student = new Student(id, newName, newGrade);
                found = true;
                break;
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    public Student searchStudent(int id) {
        Node current = this.top;
        while (current != null) {
            if (current.student.getId() == id) {
                return current.student;
            }
            current = current.next;
        }
        return null;
    }

    public void deleteStudent(int id) {
        Node current = this.top;
        Node previous = null;

        while (current != null) {
            if (current.student.getId() == id) {
                if (previous == null) {
                    this.top = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                System.out.println("Deleted student with ID " + id);
                return;
            }
            previous = current;
            current = current.next;
        }
        System.out.println("Student with ID " + id + " not found.");
    }
}
