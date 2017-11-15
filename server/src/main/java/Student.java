public class Student {
    private String id;
    private String studentID;
    private String name;
    private  String surname;
    private String group;

    public Student(String studentID, String name, String surname, String group) {
        this.studentID = studentID;
        this.name = name;
        this.surname = surname;
        this.group = group;
    }

    public Student() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", studentID='" + studentID + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", group='" + group + '\'' +
                '}';
    }
}
