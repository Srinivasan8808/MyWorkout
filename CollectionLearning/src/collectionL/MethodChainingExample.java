package collectionL;

class StudentChaining {

    private int rollNo;
    private String name;
    private String grade;
    private String course;

    // Setter methods returning 'this'
    public StudentChaining setCourse(String course) {
        this.course = course;
        return this;
    }

    public StudentChaining setRoolNo(int roolNo) {
        this.rollNo = roolNo;
        return this;
    }

    public StudentChaining setName(String name) {
        this.name = name;
        return this;
    }

    public StudentChaining setGrade(String grade) {
        this.grade = grade;
        return this;
    }

    public void display() {
        System.out.println("Name: " + name + ", RollNo: " + rollNo +
                           ", Grade: " + grade + ", Course: " + course);
    }
}

public class MethodChainingExample {
    public static void main(String[] args) {
        StudentChaining st = new StudentChaining()
                .setRoolNo(1)
                .setCourse("B.TECH")
                .setGrade("A")
                .setName("Srinivasan");

        st.display();
    }
}
