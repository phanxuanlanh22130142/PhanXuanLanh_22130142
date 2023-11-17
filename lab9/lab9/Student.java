package lab9;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private int id;
    private String name;
    private int year;
    private List<Course> courses; 
    public Student(int id, String name, int year) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.courses = new ArrayList<>(); // Khởi tạo danh sách khóa học trống
    }
    

	public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void dropCourse(Course course) {
        courses.remove(course);
    }
    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "'}";
    }
}