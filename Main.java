package Park_HW1;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		DATA.deserialize();
		Scanner scan = new Scanner(System.in);
		
		Admin a = new Admin();
		Student s = new Student("Kevin","Park");
		
		boolean loggedIn = false;
		boolean adminLoggedIn = false;
		boolean studentLoggedIn = false;
		boolean check = true; //might be unnecessary
		
		//Program on
		System.out.println("\n\n\n\nHello, welcome to your course registration system.\n");
			
		while (!loggedIn) {
			System.out.println("Are you a student or an admin?");
			System.out.println("1)Student \n2)Admin \n3)Exit");
				
			int userTypeInt = 0;
			userTypeInt = scan.nextInt();
				
			while (userTypeInt != 3 && userTypeInt != 2 && userTypeInt != 1) {
				System.out.println("Invalid input. Enter a number from 1-3.");
				System.out.println("Are you a student or an admin?");
				System.out.println("1)Student \n2)Admin \n3)Exit");
			}
			
			if (userTypeInt == 1) {
				while (check) {
					System.out.println("Please enter your student username: ");
					String inputUsername = scan.next();
					System.out.println("Please enter your student password: ");
					String inputPassword = scan.next();
					
					if (inputUsername.equals("Student") && inputPassword.equals("Student001")){
						System.out.println("Successfully logged in as a student.");
						check = false;
						loggedIn = true;
						studentLoggedIn = true;
					}
					else {
						System.out.println("Invalid login.");
					}
				}
			}
			
			if (userTypeInt == 2) {
				while (check) {
					System.out.println("Please enter your admin username: ");
					String inputUsername = scan.next();
					System.out.println("Please enter your admin password: ");
					String inputPassword = scan.next();
					
					if (inputUsername.equals("Admin") && inputPassword.equals("Admin001")){
						System.out.println("Successfully logged in as an admin.");
						check = false;
						loggedIn = true;
						adminLoggedIn = true;
					}
					else {
						System.out.println("Invalid Login.");
					}
					
				}
			}
			
			if (userTypeInt == 3) {
				a.Exit();
			}
				
		}
		while (studentLoggedIn) {
			System.out.println("1)View all courses\n2)View all classes that are not full"
					+ "\n3)Register in a Course\n4)Withdraw from a course"
					+ "\n5)View all courses currently registered in\n6)Exit");
			
			int i = 0;
			i = scan.nextInt();
			
			while (i < 1 && i > 6) {
				System.out.println("Invalid input. Enter a number from 1-6.");
				System.out.println("1)View all courses\n2)View all classes that are not full"
						+ "\n3)Register in a Course\n4)Withdraw from a course"
						+ "\n5)View all courses currently registered in\n6)Exit");
			}
			
			if (i == 1) {
				System.out.println(s.viewCourses());
				break;
			}
			if (i == 2) {
				System.out.println(s.viewOpenCourses());
				break;
			}
			if (i == 3) {
//				System.out.println("Enter the name of the course to be registered in: ");
				s.registerInCourse();
				break;
			}
			if (i == 4) {
//				System.out.println("Enter the name of the course to be withdrawn from: ");
				s.withdraw();
				break;
			}
			if (i == 5) {
				System.out.println(s.viewEnrolledCourses());
				break;
			}
			if (i == 6) {
				studentLoggedIn = false;
				loggedIn = false;
				System.out.println("Returning to login.");
				break;
			}
		}
		
		
		while (adminLoggedIn) {
			System.out.println("1)Course management\n2)Reports\n3)Exit");
			
			int i = 0;
			i = scan.nextInt();
			
			while (i != 3 && i != 2 && i !=1) {
				System.out.println("Invalid input. Enter a number from 1-3.");
				System.out.println("1)Course management\n2)Reports\n3)Exit");
			}
			//Course management menu
			while (i == 1) {
				System.out.println("1)Create a course\n2)Delete a course\n"
						+ "3)Edit a course\n4)Display course information\n"
						+ "5)Register a student\n6)Exit");
				
				int ii = 0;
				ii = scan.nextInt();
				
				while (ii < 0 && ii > 6) {
					System.out.println("Invalid input. Enter a number from 1-6.");
					System.out.println("1)Create a course\n2)Delete a course\n"
							+ "3)Edit a course\n4)Display course information\n"
							+ "5)Register a student\n6)Exit");
				}
				
				if (ii == 1) {
					System.out.println("Enter of the name of the course to be created: ");
					scan.nextLine();
					String courseName = scan.nextLine();
					
					System.out.println("Enter the course ID: ");
					String courseID = scan.next();
					
					System.out.println("Enter the maximum number of students allowed in this course: ");
					int maxStudents = scan.nextInt();
					
					System.out.println("Enter the name of the instructor: ");
					scan.nextLine();
					String instructor = scan.nextLine();
					
					System.out.println("Enter the section number: ");
					int sectionNum = scan.nextInt();
					
					System.out.println("Enter the location for the course: ");
					scan.nextLine();
					String courseLocation = scan.nextLine();
					
					a.createCourse(courseName, courseID, maxStudents, instructor, sectionNum, courseLocation);
					System.out.println("Course Created\n");
					break;
				}
				if (ii == 2) {
//					System.out.println("Enter the name of the course to be deleted: ");
//					String b = scan.nextLine();
					a.deleteCourse();
					break;
				}
				if (ii == 3) {
					System.out.println("Enter the name of the course to be edited: ");
					scan.nextLine();
					String tempEditCourse = scan.nextLine();
					
					int iii = 0;
					System.out.println("What is to be edited?: \n"
							+ "1)Course name\n2)Course ID\n3)Maximum amount of students\n"
							+ "4)Professor\n5)Section number\n6)Location");
					
					while (iii < 1 && iii > 6) {
						System.out.println("Invalid input. Enter a number from 1-6.");
						System.out.println("What is to be edited?: \n"
								+ "1)Course name\n2)Course ID\n3)Maximum amount of students\n"
								+ "4)Professor\n5)Section number\n6)Location");
					}
					
					System.out.println("Enter the edited input: ");
					a.editCourse(tempEditCourse, iii, scan.nextLine());
					break;
				}
				if (ii == 4) {
					System.out.println("Enter the course ID: ");
					scan.nextLine();
					String tempID = scan.nextLine();
					System.out.println(a.courseInfo(tempID));//change to next()?
					break;
				}
				if (ii == 5) {
					System.out.println("Enter the first name of the student to be registered: ");
					scan.nextLine();
					String first = scan.nextLine();
					System.out.println("Enter the last name of the student to be registered: ");
					String last = scan.nextLine();
					
					a.registerStudent(first, last);
					break;

				}
				if (ii == 6) {
					a.Exit();
				}
				
			}
			//Reports menu
			while (i == 2) {
				System.out.println("1)View all courses\n2)View all full courses\n"
						+ "3)Write list of full classes to file\n4)View the names "
						+ "of the students being registered in the specific course\n"
						+ "5)View the list of courses that a given student is being "
						+ "registered on\n6)Sort the courses based on the number of "
						+ "current registered students\n7)Exit");
				
				int iiii = 0;
				iiii = scan.nextInt();
				
				while(iiii < 1 && iiii > 7) {
					System.out.println("Invalid input. Enter a number from 1-7.");
					System.out.println("1)View all courses\n2)View all full courses\n"
							+ "3)Write list of full classes to file\n4)View the names "
							+ "of the students being registered in the specific course\n"
							+ "5)View the list of courses that a given student is being "
							+ "registered on\n6)Sort the courses based on the number of "
							+ "current registered students\n7)Exit");
				}
				
				if (iiii == 1) {
					System.out.println(a.viewCourses());
					break;
				}
				if (iiii == 2) {
					System.out.println(a.viewFullCourses());
					break;
				}
				if (iiii == 3) {
					a.writeFullCoursesToFile();
					break;
				}
				if (iiii == 4) {
					System.out.println("Enter the course name: ");
					scan.nextLine();
					String temps = scan.nextLine();
//					System.out.println(temps + " stored in temps");
					System.out.println(a.studentsInCourse(temps));
					break;
				}
				if (iiii == 5) {
					System.out.println("Enter the student's full name: ");
					scan.nextLine();
					String tempss = scan.nextLine();
//					System.out.println(tempss);
//					System.out.println(a.findStudent(tempss));
					System.out.println(a.studentEnrolledCourses(tempss));
					break;
				}
				if (iiii == 6) {
					a.sortCourses();
					break;
				}
				if (iiii == 7) {
					a.Exit();
				}
				
			}
			
			if (i == 3) {
				adminLoggedIn = false;
				loggedIn = false;
				System.out.println("Returning to login");
			}
			
		}
		scan.close();
		DATA.serialize();
		System.out.println("Ending course registration. See you on campus!");
			
	}
	

}