package Park_HW1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;

public class Admin extends User implements AdminInterface{
	private static final long serialVersionUID = 1L;
	Scanner scan = new Scanner(System.in);

	public Admin() {
		super();
		username = "Admin";
		password = "Admin001";
	}
	
	//Create a course
	public void createCourse(String courseName, String courseID, int maxStudents, String instructor, int sectionNum, String courseLocation) {
		Course i = new Course(courseName, courseID, maxStudents, instructor, sectionNum, courseLocation);
		DATA.courses.add(i);
		System.out.println(i.getCourseName() + " has been added as a course.");
	}
	
	//Delete a Course
	public void deleteCourse() {
		System.out.println("Enter the name of course to be deleted: ");
//		scan.nextLine();
		String name = scan.nextLine();
		for (Course i : DATA.courses) {
			if (name.equalsIgnoreCase(i.getCourseName())) {
				DATA.courses.remove(i);
				System.out.println(i.getCourseName() + " has been deleted.");
				return;
			}
			else {
				System.out.println("Course not found.");
//				return;

			}
		}
	}
	
	//Edit a course
	public void editCourse(String nameOfCourse, int n, String input) {
		try {
			Course i = findCourse(nameOfCourse);
			
			if (n == 1) {
				i.setCourseName(input);
			}
			
			if (n == 2) {
				i.setCourseID(input);
			}
			
			if (n == 3) {
				try {
					int a = Integer.parseInt(input);
					if (a > 0) {
						i.setMaxStudents(a);
						System.out.println("Max # of students: " + a);
					}
				}
				catch (NumberFormatException e) {
					System.out.println("Invalid # of max students.");
				}
			}
			
			if (n == 4) {
				i.setInstructorName(input);
			}
			
			if (n == 5) {
				try {
					int a = Integer.parseInt(input);
					i.setSectionNumber(a);
				}
				catch (NumberFormatException e) {
					System.out.println("Invalid "
							+ "# for section number.");
				}
			}
			
			if (n == 6) {
				i.setCourseLocation(input);
			}
			
		}
		catch (NullPointerException e){
			
		}
		
	}
	//Display information by course ID
	public String courseInfo(String CourseID) {
		for (Course i : DATA.courses) {
			if (CourseID.equalsIgnoreCase(i.getCourseID())) {
				return i.toString();
			}
		}
		return "courseinfo() could not find the course based off the course ID";
	}
	//Register a student
	public void registerStudent(String first, String last) {
		Student i = new Student(first, last);
		DATA.students.add(i);
		System.out.println(i.getFullName() + " registered.");
		System.out.println("\n");

	}
	//View courses that are full
	public String viewFullCourses() {
		String fullCourses = "";
		for (Course i : DATA.courses) {
			if (i.courseIsFull())
				fullCourses += i.getCourseName() + "";
		}
		
		if (fullCourses.isEmpty()) {
			return "Full courses not found.";
		}
		else {
			return fullCourses;
		}
	}
	//Write to a file the list of courses that are full
	public void writeFullCoursesToFile() {
		
		int n = 0;
		String fileName = "Full Courses";
		File txtfile = new File(fileName + ".txt");
		
		while (txtfile.exists()) {
			txtfile = new File(fileName + "(" + (n++) + ").txt");
		}
		
		try {
			FileWriter writer = new FileWriter(txtfile);
			String output = this.viewFullCourses();
			for (int i = 0; i < output.length();i++) {
				writer.write(output.charAt(i));
			}
			writer.close();
			
			System.out.println("Full courses are successfully written to .txt file.");
			System.out.println("\n");

			
		} catch (IOException e) {
			e.getStackTrace();
		}
		
	}
	//Sort the courses based on student count
	public void sortCourses() {
		Collections.sort(DATA.courses);
		System.out.println("Courses sorted!");
		
	}
	
	@Override
	public String viewCourses() {
		String courseList = "";
		for (Course i : DATA.courses) {
			courseList = courseList + i;
			System.out.println("\n");
		}
		return courseList;
	}
	
	//Used in later method
	public Student findStudent(String name) {
		if (!DATA.students.isEmpty()) {
			for (Student i : DATA.students) {
				if (i.getFullName().contentEquals(name)) {
					return i;
				}
			}
			System.out.println("Invalid student name (findStudent())");
			System.out.println("\n");

			
		}
		return null;
		
	}
	
	//View the list of courses that a given student is being registered on
	public String studentEnrolledCourses(String nameOfStudent) {
		try {
			Student i = findStudent(nameOfStudent);
			return i.viewEnrolledCourses();
		} catch (NullPointerException e) {
			return "";//from return ""
		}
	}
	//View the names of students being registered in a specific course
	public String studentsInCourse(String nameOfCourse) {
		try {
			Course c = findCourse(nameOfCourse);
			return c.getStudents();
		} catch (NullPointerException e) {
			return "";//from return ""
		}
	}
	



}
