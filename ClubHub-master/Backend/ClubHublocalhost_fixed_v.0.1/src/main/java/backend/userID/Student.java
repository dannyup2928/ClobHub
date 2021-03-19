package backend.userID;

import java.util.List;

public class Student {
    private List<userID> Student;

    public Student(List<userID> Student) {
        this.Student = Student;
    }

    public List<userID> getStudent() {
        return Student;
    }
}