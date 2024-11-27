public class Student {
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
        if (!(this.grade < (double)0.0F) && !(this.grade > (double)10.0F)) {
            if (this.grade < (double)5.0F) {
                return "Fail";
            } else if (this.grade < (double)6.5F) {
                return "Medium";
            } else if (this.grade < (double)7.5F) {
                return "Good";
            } else {
                return this.grade < (double)9.0F ? "Very Good" : "Excellent";
            }
        } else {
            return "Invalid grade";
        }
    }

    public String toString() {
        int var10000 = this.id;
        return "Student{id=" + var10000 + ", name='" + this.name + "', grade=" + this.grade + ", rank=" + this.getRank() + "}";
    }
}
