import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class School {
    private Map<String, ClassRoom> classRooms;
    private Map<String, Set<ClassRoom>> studentClasses;

    public School() {
        classRooms = new HashMap<>();
        studentClasses = new HashMap<>();
    }

    public void addClassRoom(String className) {
        classRooms.putIfAbsent(className, new ClassRoom(className));
    }

    public void addStudentToClass(Student student, String className) {
        ClassRoom classRoom = classRooms.get(className);
        if (classRoom != null && classRoom.addStudent(student)) {
            studentClasses.computeIfAbsent(student.getStudentId(), k -> new HashSet<>()).add(classRoom);
        }
    }

    public void removeStudentFromClass(Student student, String className) {
        ClassRoom classRoom = classRooms.get(className);
        if (classRoom != null && classRoom.removeStudent(student)) {
            Set<ClassRoom> classes = studentClasses.get(student.getStudentId());
            if (classes != null) {
                classes.remove(classRoom);
                if (classes.isEmpty()) {
                    studentClasses.remove(student.getStudentId());
                }
            }
        }
    }

    public boolean isStudentInClass(Student student, String className) {
        ClassRoom classRoom = classRooms.get(className);
        return classRoom != null && classRoom.hasStudent(student);
    }

    public void displayStudentsInClass(String className) {
        ClassRoom classRoom = classRooms.get(className);
        if (classRoom != null) {
            classRoom.displayStudents();
        } else {
            System.out.println("Class not found!");
        }
    }

    public void displayStats() {
        int multiClassStudents = 0;
        for (Set<ClassRoom> classes : studentClasses.values()) {
            if (classes.size() > 1) {
                multiClassStudents++;
            }
        }
        System.out.println("Students enrolled in more than one class: " + multiClassStudents);
    }
}
