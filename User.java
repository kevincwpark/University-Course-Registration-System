package Park_HW1;

import java.io.Serializable;

public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	protected String username;
	protected String password;
	protected String firstName;
	protected String lastName;
	
	public User() {
	}
	
	public User(String username, String password, String firstName, String lastName) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	//getters and setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFullName() {
		String fullName = firstName + " " + lastName;
		return fullName;
	}
	
	public void setFullName(String fullNameWithSpace) {
		String[] namesArray = fullNameWithSpace.split(" ");
		firstName = namesArray[0];
		lastName = namesArray[1];
		
	}
	//View all courses
	public String viewCourses() {
		String courseList = "Viewing Courses: \n\n";
		for (Course i : DATA.courses) {
			courseList = courseList + i.getCourseName() + "\n";
		}
		return courseList;
	}
	//Serialize then quit
	public void Exit() {
		DATA.serialize();
		System.exit(0);
	}
	//Find the course off name
	public Course findCourse(String nameOfCourse) {
		for (Course i : DATA.courses) {
//			System.out.println(i.getCourseName());
//			System.out.println(nameOfCourse);
			if (i.getCourseName().contentEquals(nameOfCourse)) {
//				System.out.println("DINGDINGDING");
				return i;
			}
			
//		System.out.println("The course that you input does not exist. ");
				
			
			
			
		}
		return null;
		
		
	}
	

}
