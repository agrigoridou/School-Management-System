/**
 * Κύρια κλάση Main που περιέχει τη μέθοδο main και υλοποιεί την αλληλεπίδραση με το σχολικό σύστημα.
 */
public class Main {
    public static void main(String[] args) {
        // Δημιουργία αντικειμένου School που διαχειρίζεται τάξεις και μαθητές
        School school = new School();

        // Δημιουργία τάξεων
        school.addClassRoom("Positive Sciences"); // Προσθήκη τάξης "Θετικές Επιστήμες"
        school.addClassRoom("Philosophy");        // Προσθήκη τάξης "Φιλοσοφία"
        school.addClassRoom("Mathematics");       // Προσθήκη τάξης "Μαθηματικά"

        // Δημιουργία αντικειμένων μαθητών
        Student student1 = new Student("John Doe", "001", "john@example.com");    // Μαθητής 1
        Student student2 = new Student("Jane Smith", "002", "jane@example.com");  // Μαθητής 2
        Student student3 = new Student("Mike Johnson", "003", "mike@example.com");// Μαθητής 3

        // Προσθήκη μαθητών στις τάξεις
        school.addStudentToClass(student1, "Positive Sciences"); // Προσθήκη του John Doe στη "Θετικές Επιστήμες"
        school.addStudentToClass(student1, "Mathematics");       // Προσθήκη του John Doe στα "Μαθηματικά"
        school.addStudentToClass(student2, "Philosophy");        // Προσθήκη της Jane Smith στη "Φιλοσοφία"
        school.addStudentToClass(student3, "Mathematics");       // Προσθήκη του Mike Johnson στα "Μαθηματικά"

        // Αναζήτηση μαθητή σε τάξη
        System.out.println("Is John Doe in Mathematics? " + school.isStudentInClass(student1, "Mathematics"));
        // Έλεγχος αν ο John Doe είναι στη "Μαθηματικά"

        System.out.println("Is Jane Smith in Positive Sciences? " + school.isStudentInClass(student2, "Positive Sciences"));
        // Έλεγχος αν η Jane Smith είναι στη "Θετικές Επιστήμες"

        // Εμφάνιση μαθητών που ανήκουν στη τάξη "Μαθηματικά"
        school.displayStudentsInClass("Mathematics");

        // Εμφάνιση στατιστικών μαθητών
        school.displayStats(); // Μαθητές που ανήκουν σε περισσότερες από μία τάξεις

        // Αφαίρεση μαθητή από μια τάξη
        school.removeStudentFromClass(student1, "Mathematics"); // Αφαίρεση του John Doe από τη "Μαθηματικά"

        // Εμφάνιση μαθητών στη τάξη "Μαθηματικά" μετά την αφαίρεση
        school.displayStudentsInClass("Mathematics");
    }
}
