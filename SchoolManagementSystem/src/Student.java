public class Student {
    private String fullName;
    private String studentId;
    private String contactInfo;

    public Student(String fullName, String studentId, String contactInfo) {
        this.fullName = fullName;
        this.studentId = studentId;
        this.contactInfo = contactInfo;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return studentId.equals(student.studentId);
    }

    @Override
    public int hashCode() {
        return studentId.hashCode();
    }

    @Override
    public String toString() {
        return fullName + " (" + studentId + ") - Contact: " + contactInfo;
    }
}
