package Park_HW1;

import java.io.Serializable;
import java.util.ArrayList;

public class Course implements Serializable, Comparable<Course>{
	private static final long serialVersionUID = 1L;
	
	private String courseName;
	private String courseID;
	private int maxStudents;
	private int currentStudents;
	private ArrayList<Student> students = new ArrayList<Student>();
	private String instructorName;
	private int sectionNumber;
	private String courseLocation;
	
	public Course(String courseName, String courseID, int maxStudents, String instructorName, int sectionNumber,
			String courseLocation) {
		this.courseName = courseName;
		this.courseID = courseID;
		this.maxStudents = maxStudents;
		this.instructorName = instructorName;
		this.sectionNumber = sectionNumber;
		this.courseLocation = courseLocation;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public int getMaxStudents() {
		return maxStudents;
	}

	public void setMaxStudents(int maxStudents) {
		this.maxStudents = maxStudents;
	}

	public String getInstructorName() {
		return instructorName;
	}

	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}

	public int getSectionNumber() {
		return sectionNumber;
	}

	public void setSectionNumber(int sectionNumber) {
		this.sectionNumber = sectionNumber;
	}

	public String getCourseLocation() {
		return courseLocation;
	}

	public void setCourseLocation(String courseLocation) {
		this.courseLocation = courseLocation;
	}
	
	//Adds a student to the course and increments the number of enrolled students
	public void addStudent(Student i)  {
		students.add(i);
		currentStudents = currentStudents + 1;
	}
	
	public void removeStudent(Student i) {
		for (Student name : students) {
			if(i.getFullName().contentEquals(name.getFullName())) {
				students.remove(i);
				currentStudents = currentStudents - 1;
				return;
			}
		}
	}
	
	//Checks to see if this course is full
	public boolean courseIsFull() {
		if (maxStudents > currentStudents) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public String getStudents() {
		if (!students.isEmpty()) {
			String studentList = "Enrolled Students: \n";
			for (Student s : students) {
				studentList += s.getFullName() + "\n";
			}
			return studentList;
		}
			return "There are no students enrolled in this course.\n";
	}
	
	public boolean hasStudent(String studentName) {
		if (!students.isEmpty()) {
			for (Student s : students) {
				if (s.getFullName().equalsIgnoreCase(studentName)) {
					return true;
				}
			}
			return false;
		}
		return false;
	}
	
	public String toString() {
		return "Course Name: " + courseName + "\nCourse ID: " + courseID + "\nMax Capacity: " + maxStudents 
				+ "\nAmount of currently enrolled students: " + currentStudents + "\nInstructor: " 
				+ instructorName + "\nSection Number: " + sectionNumber + "\nLocation: " + courseLocation + "\n";
	}

	@Override
	public int compareTo(Course o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
