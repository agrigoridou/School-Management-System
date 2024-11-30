import java.util.HashSet;
import java.util.Set;

/**
 * Η κλάση ClassRoom αναπαριστά μια τάξη του σχολείου, η οποία περιέχει ένα σύνολο μαθητών.
 * Υποστηρίζει την προσθήκη, αφαίρεση και εμφάνιση μαθητών, καθώς και την αναζήτηση ενός μαθητή.
 */
public class ClassRoom {
    // Το όνομα της τάξης
    private String className;

    // Σύνολο μαθητών που ανήκουν στην τάξη
    private Set<Student> students;

    /**
     * Constructor: Αρχικοποιεί μια τάξη με το δεδομένο όνομα και ένα κενό σύνολο μαθητών.
     *
     * @param className Το όνομα της τάξης.
     */
    public ClassRoom(String className) {
        this.className = className;
        this.students = new HashSet<>();
    }

    /**
     * Επιστρέφει το όνομα της τάξης.
     *
     * @return Το όνομα της τάξης.
     */
    public String getClassName() {
        return className;
    }

    /**
     * Προσθέτει έναν μαθητή στην τάξη.
     *
     * @param student Το αντικείμενο μαθητή που θα προστεθεί.
     * @return true αν ο μαθητής προστέθηκε επιτυχώς, false αν υπάρχει ήδη στην τάξη.
     */
    public boolean addStudent(Student student) {
        return students.add(student);
    }

    /**
     * Αφαιρεί έναν μαθητή από την τάξη.
     *
     * @param student Το αντικείμενο μαθητή που θα αφαιρεθεί.
     * @return true αν ο μαθητής αφαιρέθηκε επιτυχώς, false αν δεν υπήρχε στην τάξη.
     */
    public boolean removeStudent(Student student) {
        return students.remove(student);
    }

    /**
     * Ελέγχει αν ένας συγκεκριμένος μαθητής ανήκει στην τάξη.
     *
     * @param student Το αντικείμενο μαθητή που θα ελεγχθεί.
     * @return true αν ο μαθητής υπάρχει στην τάξη, false αλλιώς.
     */
    public boolean hasStudent(Student student) {
        return students.contains(student);
    }

    /**
     * Εμφανίζει τους μαθητές που ανήκουν στην τάξη.
     * Τυπώνει το όνομα της τάξης και τη λίστα των μαθητών.
     */
    public void displayStudents() {
        System.out.println("Students in " + className + ":");
        for (Student student : students) {
            System.out.println(student); // Καλεί το toString() του Student
        }
    }

    /**
     * Επιστρέφει τον αριθμό των μαθητών που ανήκουν στην τάξη.
     *
     * @return Ο αριθμός των μαθητών.
     */
    public int getNumStudents() {
        return students.size();
    }
}
