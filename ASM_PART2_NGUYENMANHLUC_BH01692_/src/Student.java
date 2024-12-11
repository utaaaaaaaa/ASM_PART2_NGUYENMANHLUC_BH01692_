class Student {
    private int id;
    private String name;
    private double grade;

    public Student(int id, String name, double grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getGrade() {
        return this.grade;
    }

    public String getRank() {
        if (this.grade < 0.0 || this.grade > 10.0) {
            return "Invalid grade";
        } else if (this.grade < 5.0) {
            return "Fail";
        } else if (this.grade < 6.5) {
            return "Medium";
        } else if (this.grade < 7.5) {
            return "Good";
        } else if (this.grade < 9.0) {
            return "Very Good";
        } else {
            return "Excellent";
        }
    }

    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', grade=" + (String.format("%.1f",grade)) + ", rank=" + getRank() + "}";
    }

}
