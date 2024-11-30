import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Η κλάση School διαχειρίζεται τη δομή ενός ιδιωτικού σχολείου, που περιλαμβάνει τάξεις και μαθητές.
 * Υποστηρίζει την προσθήκη και διαγραφή μαθητών, την αναζήτηση μαθητών σε τάξεις,
 * την εμφάνιση μαθητών ανά τάξη, καθώς και στατιστικά για τους μαθητές.
 */
public class School {
    // Map για την αποθήκευση τάξεων με βάση το όνομά τους
    private Map<String, ClassRoom> classRooms;

    // Map για την παρακολούθηση των τάξεων στις οποίες ανήκει κάθε μαθητής (με βάση το studentId)
    private Map<String, Set<ClassRoom>> studentClasses;

    /**
     * Constructor: Αρχικοποιεί τα Map για τις τάξεις και τους μαθητές.
     */
    public School() {
        classRooms = new HashMap<>();
        studentClasses = new HashMap<>();
    }

    /**
     * Προσθέτει μια νέα τάξη στο σχολείο.
     * Αν η τάξη υπάρχει ήδη, δεν την αντικαθιστά.
     *
     * @param className Το όνομα της τάξης.
     */
    public void addClassRoom(String className) {
        classRooms.putIfAbsent(className, new ClassRoom(className));
    }

    /**
     * Προσθέτει έναν μαθητή σε μια τάξη.
     * Ενημερώνει και τη λίστα με τις τάξεις στις οποίες ανήκει ο μαθητής.
     *
     * @param student Το αντικείμενο μαθητή.
     * @param className Το όνομα της τάξης.
     */
    public void addStudentToClass(Student student, String className) {
        ClassRoom classRoom = classRooms.get(className);
        // Αν η τάξη υπάρχει και ο μαθητής προστέθηκε επιτυχώς στην τάξη
        if (classRoom != null && classRoom.addStudent(student)) {
            // Ενημέρωσε τη λίστα τάξεων του μαθητή
            studentClasses.computeIfAbsent(student.getStudentId(), k -> new HashSet<>()).add(classRoom);
        }
    }

    /**
     * Αφαιρεί έναν μαθητή από μια τάξη.
     * Αν ο μαθητής δεν ανήκει σε καμία άλλη τάξη, διαγράφεται από το Map studentClasses.
     *
     * @param student Το αντικείμενο μαθητή.
     * @param className Το όνομα της τάξης.
     */
    public void removeStudentFromClass(Student student, String className) {
        ClassRoom classRoom = classRooms.get(className);
        if (classRoom != null && classRoom.removeStudent(student)) {
            // Ενημέρωσε τη λίστα τάξεων του μαθητή
            Set<ClassRoom> classes = studentClasses.get(student.getStudentId());
            if (classes != null) {
                classes.remove(classRoom);
                // Αν ο μαθητής δεν ανήκει πλέον σε καμία τάξη, διαγράψτε τον από το studentClasses
                if (classes.isEmpty()) {
                    studentClasses.remove(student.getStudentId());
                }
            }
        }
    }

    /**
     * Ελέγχει αν ένας μαθητής ανήκει σε μια συγκεκριμένη τάξη.
     *
     * @param student Το αντικείμενο μαθητή.
     * @param className Το όνομα της τάξης.
     * @return true αν ο μαθητής είναι εγγεγραμμένος στην τάξη, αλλιώς false.
     */
    public boolean isStudentInClass(Student student, String className) {
        ClassRoom classRoom = classRooms.get(className);
        return classRoom != null && classRoom.hasStudent(student);
    }

    /**
     * Εμφανίζει όλους τους μαθητές που ανήκουν σε μια συγκεκριμένη τάξη.
     * Αν η τάξη δεν βρεθεί, εμφανίζει μήνυμα σφάλματος.
     *
     * @param className Το όνομα της τάξης.
     */
    public void displayStudentsInClass(String className) {
        ClassRoom classRoom = classRooms.get(className);
        if (classRoom != null) {
            classRoom.displayStudents();
        } else {
            System.out.println("Class not found!");
        }
    }

    /**
     * Εμφανίζει στατιστικά για τους μαθητές:
     * Υπολογίζει και εμφανίζει πόσοι μαθητές ανήκουν σε περισσότερες από μία τάξεις.
     */
    public void displayStats() {
        int multiClassStudents = 0;
        // Ελέγχει το πλήθος τάξεων για κάθε μαθητή
        for (Set<ClassRoom> classes : studentClasses.values()) {
            if (classes.size() > 1) {
                multiClassStudents++;
            }
        }
        System.out.println("Students enrolled in more than one class: " + multiClassStudents);
    }
}
