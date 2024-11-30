/**
 * Η κλάση Student αναπαριστά έναν μαθητή με μοναδικό αναγνωριστικό, πλήρες όνομα και στοιχεία επικοινωνίας.
 */
public class Student {
    // Το πλήρες όνομα του μαθητή
    private String fullName;

    // Ο μοναδικός αριθμός αναγνωριστικού του μαθητή
    private String studentId;

    // Τα στοιχεία επικοινωνίας του μαθητή
    private String contactInfo;

    /**
     * Constructor: Αρχικοποιεί ένα αντικείμενο Student με τα παρεχόμενα στοιχεία.
     *
     * @param fullName    Το πλήρες όνομα του μαθητή.
     * @param studentId   Ο μοναδικός αριθμός αναγνωριστικού του μαθητή.
     * @param contactInfo Τα στοιχεία επικοινωνίας του μαθητή.
     */
    public Student(String fullName, String studentId, String contactInfo) {
        this.fullName = fullName;
        this.studentId = studentId;
        this.contactInfo = contactInfo;
    }

    /**
     * Επιστρέφει το μοναδικό αναγνωριστικό του μαθητή.
     *
     * @return Το studentId.
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * Επιστρέφει το πλήρες όνομα του μαθητή.
     *
     * @return Το fullName.
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Επιστρέφει τα στοιχεία επικοινωνίας του μαθητή.
     *
     * @return Το contactInfo.
     */
    public String getContactInfo() {
        return contactInfo;
    }

    /**
     * Ελέγχει αν δύο αντικείμενα Student είναι ίσα με βάση το μοναδικό αναγνωριστικό τους.
     *
     * @param obj Το αντικείμενο προς σύγκριση.
     * @return true αν τα αντικείμενα έχουν το ίδιο studentId, false αλλιώς.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Ελέγχει αν είναι το ίδιο αντικείμενο
        if (obj == null || getClass() != obj.getClass()) return false; // Ελέγχει τύπο κλάσης
        Student student = (Student) obj;
        return studentId.equals(student.studentId); // Συγκρίνει τα studentId
    }

    /**
     * Υπολογίζει τον hashcode για τον μαθητή με βάση το μοναδικό αναγνωριστικό του.
     *
     * @return Ο hashcode του studentId.
     */
    @Override
    public int hashCode() {
        return studentId.hashCode();
    }

    /**
     * Επιστρέφει μια συμβολοσειρά με τις πληροφορίες του μαθητή.
     *
     * @return Μια συμβολοσειρά με τη μορφή: "Πλήρες Όνομα (ID) - Contact: Στοιχεία Επικοινωνίας".
     */
    @Override
    public String toString() {
        return fullName + " (" + studentId + ") - Contact: " + contactInfo;
    }
}
