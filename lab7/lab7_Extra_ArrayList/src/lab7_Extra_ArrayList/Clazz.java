package lab7_Extra_ArrayList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;

public class Clazz {
    private String name;
    private String year;
    private ArrayList<Student> students = new ArrayList<Student>();

    public Clazz(String name, String year) {
        this.name = name;
        this.year = year;
    }

    // load all students from filename into the list of students
    public void loadStudents(String fileName) throws IOException {
        students = StudentUtils.loadStudents(fileName);
    }

    // sort students according to the given comparator
    public void sortStudents(Comparator<Student> comparator) {
        Collections.sort(students, comparator);
    }

    // get top n students with highest
    public ArrayList<Student> getTopNStudents(int n) {
        if (n > students.size()) {
            n = students.size();
        }
        ArrayList<Student> topStudents = new ArrayList<>(students.subList(0, n));
        return topStudents;
    }

    // remove a student with a given id
    public boolean removeStudent(String id) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getId().equals(id)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    // get all students who were born in a given birth year.
    public ArrayList<Student> getStudentByBirthYear(int birthYear) {
        ArrayList<Student> studentsByBirthYear = new ArrayList<>();
        for (Student student : students) {
            if (student.getBirthYear() == birthYear) {
                studentsByBirthYear.add(student);
            }
        }
        return studentsByBirthYear;
    }

    // get random n students from the list of students
    public ArrayList<Student> getRandomNStudents(int n) {
        ArrayList<Student> randomStudents = new ArrayList<>();
        int size = students.size();
        if (n > size) {
            n = size;
        }
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int index = random.nextInt(size);
            randomStudents.add(students.get(index));
        }
        return randomStudents;
    }

    // similar as toString method, this method prints the name, year, and all students of the class.
    // Note that, using iterator
    @Override
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Class: ").append(name).append(", Year: ").append(year).append("\n");
        sb.append("Students:").append("\n");
        for (Student student : students) {
            sb.append(student).append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        Clazz clazz = new Clazz("Class 1", "2022");

        // Load students from a file
        clazz.loadStudents("D:\\lab7\\lab7_Extra_ArrayList\\src\\lab7_Extra_ArrayList\\students");

        // Display the class information
        clazz.display();

        

     
        System.out.println("Top 3 students with highest GPA:");
        for (Student student : clazz.getTopNStudents(3)){
            System.out.println(student);
        }
    }

	private void display() {
		System.out.println(this.toString());
		
	}}
	
