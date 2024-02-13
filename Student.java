package Park_HW1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;

public class Student extends User implements StudentInterface, Serializable, Comparable<Student>{
	private static final long serialVersionUID = 1L;
	ArrayList<Course> enrolledCourses = new ArrayList<Course>();
	
	public Student() {
		super();
		username = "Student";
		password = "Student001";
	}
	
	public Student(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Student login(String username, String password) {
		for (Student i : DATA.students) {
			if (username.contentEquals(i.username) && (password.contentEquals(i.password))) {
				return i;
			}
		}
		return null;
	}
	//View all courses that are not full
	public String viewOpenCourses() {
		String s = "";
		for (Course i : DATA.courses) {
			if (!i.courseIsFull()) {
				s += i.getCourseName() + "\n";
			}
		}
		return s;
	}
	//Register in a course (must enter course name, section, student full name) 
	public void registerInCourse() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter the course name: ");
		String registerCourseName = in.readLine();
		System.out.println("Enter the course section ID: ");
		String registerCourseID = in.readLine();
		System.out.println("Enter your first name: ");
		String registerFirstName = in.readLine();
		System.out.println("Enter your last name: ");
		String registerLastName = in.readLine();

		try {
			Course i = findCourse(registerCourseName);
			if (i.getCourseName().equalsIgnoreCase(registerCourseName)) {
				if (!i.courseIsFull()) {
					i.addStudent(this);
					enrolledCourses.add(i);
					System.out.println("You have been added to " + registerCourseName + " " + registerCourseID + " " + registerFirstName + " " + registerLastName + ".");
				}
				else {
					System.out.println("Error: Class is either full or you inputed the wrong class name.");
				}
			}
		} catch (NullPointerException e){
		}
	}
	
	
	//Withdraw from a course (asked to enter name and course name)
	public void withdraw() throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter the course name: ");
		String withdrawCourseName = in.readLine();
		System.out.println("Enter your first name: ");
		String withdrawFirstName = in.readLine();
		System.out.println("Enter your last name: ");
		String withdrawLastName = in.readLine();
		
		try {
			Course i = findCourse(withdrawCourseName);
			if (i.hasStudent(this.getFullName())) {
				i.removeStudent(this);
				enrolledCourses.remove(i);
				System.out.println("You have been withdrawn from " + withdrawCourseName + ", " + withdrawFirstName + " " + withdrawLastName);
			}
			else {
				System.out.println("Error: Please check your student/course name");
			} 
		} catch (NullPointerException e){
		}
	}
	
	//Overloading
	public void withdraw(Course i) {
		enrolledCourses.remove(i);
	}
	//View all courses that the student is registered in
	public String viewEnrolledCourses() {
		if (!enrolledCourses.isEmpty()) {
			String enrolled = "";
			for (Course i : enrolledCourses) {
				enrolled += i.getCourseName() + "\n";
			}
			return enrolled;
		}
		else {
			return "No enrolled classes available.\n";
		}
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
