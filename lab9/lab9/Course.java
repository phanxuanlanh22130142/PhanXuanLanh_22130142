package lab9;
import java.util.List;

class Course {
    private int id;
    private String title;
    private String type;
    private List<Student> students;
    private String lecturer;

    public Course(int id, String title, String type, List<Student> students, String lecturer) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.students = students;
        this.lecturer = lecturer;
    }

    public String getType() {
        return type;
    }

    public List<Student> getStudents() {
        return students;
    }
    public boolean isPracticalCourse() {
        return type.equals("thực hành");
    }
   
    public int getYear() {
        return 2022; 
    }

    public String getTitle() {
        return title;
    }
    @Override
    public String toString() {
        return "Course{id=" + id + ", title='" + title + "'}";
    }
}
