public class Main {
    public static void main(String[] args) {
        School school = new School();

        // Δημιουργία τάξεων
        school.addClassRoom("Positive Sciences");
        school.addClassRoom("Philosophy");
        school.addClassRoom("Mathematics");

        // Δημιουργία μαθητών
        Student student1 = new Student("John Doe", "001", "john@example.com");
        Student student2 = new Student("Jane Smith", "002", "jane@example.com");
        Student student3 = new Student("Mike Johnson", "003", "mike@example.com");

        // Προσθήκη μαθητών στις τάξεις
        school.addStudentToClass(student1, "Positive Sciences");
        school.addStudentToClass(student1, "Mathematics");
        school.addStudentToClass(student2, "Philosophy");
        school.addStudentToClass(student3, "Mathematics");

        // Αναζήτηση μαθητή σε τάξη
        System.out.println("Is John Doe in Mathematics? " + school.isStudentInClass(student1, "Mathematics"));
        System.out.println("Is Jane Smith in Positive Sciences? " + school.isStudentInClass(student2, "Positive Sciences"));

        // Εμφάνιση μαθητών σε μια τάξη
        school.displayStudentsInClass("Mathematics");

        // Στατιστικά μαθητών
        school.displayStats();

        // Αφαίρεση μαθητή από μια τάξη
        school.removeStudentFromClass(student1, "Mathematics");

        // Εμφάνιση μαθητών μετά την αφαίρεση
        school.displayStudentsInClass("Mathematics");
    }
}
