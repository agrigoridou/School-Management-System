import java.util.HashSet;
import java.util.Set;

public class ClassRoom {
    private String className;
    private Set<Student> students;

    public ClassRoom(String className) {
        this.className = className;
        this.students = new HashSet<>();
    }

    public String getClassName() {
        return className;
    }

    public boolean addStudent(Student student) {
        return students.add(student);
    }

    public boolean removeStudent(Student student) {
        return students.remove(student);
    }

    public boolean hasStudent(Student student) {
        return students.contains(student);
    }

    public void displayStudents() {
        System.out.println("Students in " + className + ":");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public int getNumStudents() {
        return students.size();
    }
}
