package lab9;
import java.util.*;

class Faculty {
    private String name;
    private String address;
    private List<Course> courses;

   
    public Faculty(String name, String address, List<Course> courses) {
        this.name = name;
        this.address = address;
        this.courses = courses;
    }
    public Course getMaxPracticalCourse() {
        
        Course maxPracticalCourse = null;
        int maxStudentCount = 0;
        for (Course course : courses) {
            if (course.isPracticalCourse() && course.getStudents().size() > maxStudentCount) {
                maxStudentCount = course.getStudents().size();
                maxPracticalCourse = course;
            }
        }
        return maxPracticalCourse;
    }

    public Map<Integer, List<Student>> groupStudentsByYear() {
        Map<Integer, List<Student>> studentsByYear = new HashMap<>();
        for (Course course : courses) {
            for (Student student : course.getStudents()) {
                int year = student.getYear();
                if (!studentsByYear.containsKey(year)) {
                    studentsByYear.put(year, new ArrayList<>());
                }
                studentsByYear.get(year).add(student);
            }
        }
        return studentsByYear;
    }
    public Set<Course> filterPracticalCourses() {
        Set<Course> practicalCourses = new HashSet<>();
        for (Course course : courses) {
            if (course.isPracticalCourse()) {
                practicalCourses.add(course);
            }
        }
        return practicalCourses;
    }
    public Set<Course> filterTheoreticalCourses() {
        Set<Course> theoreticalCourses = new HashSet<>();
        for (Course course : courses) {
            if (!course.isPracticalCourse()) {
                theoreticalCourses.add(course);
            }
        }
        return theoreticalCourses;
    }
    public static void main(String[] args) {
        
        List<Student> students1 = new ArrayList<>();
        students1.add(new Student(1, "John", 1));
        students1.add(new Student(2, "Alice", 2));
        students1.add(new Student(3, "Bob", 1));

        List<Student> students2 = new ArrayList<>();
        students2.add(new Student(4, "Eve", 3));
        students2.add(new Student(5, "Carol", 2));

        
        Course course1 = new Course(101, "Java Programming", "lý thuyết", students1, "Dr. Smith");
        Course course2 = new Course(102, "Database Management", "thực hành", students2, "Dr. Johnson");

    
        List<Course> courses = new ArrayList<>();
        courses.add(course1);
        courses.add(course2);

        
        Faculty faculty = new Faculty("ABC University", "123 Example Street", courses);

        
        Course maxPracticalCourse = faculty.getMaxPracticalCourse();
        System.out.println("Max practical course: " + maxPracticalCourse.getTitle());

        
        Map<Integer, List<Student>> studentsByYear = faculty.groupStudentsByYear();
        System.out.println("Students by year: " + studentsByYear);

        
        Set<Course> practicalCourses = faculty.filterPracticalCourses();
        System.out.println("Practical courses: " + practicalCourses);

        
        Set<Course> theoreticalCourses = faculty.filterTheoreticalCourses();
        System.out.println("Theoretical courses: " + theoreticalCourses);
    }
}
