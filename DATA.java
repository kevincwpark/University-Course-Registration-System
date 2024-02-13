package Park_HW1;

import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class DATA {
	public static ArrayList<Course> courses = new ArrayList<Course>();
	public static ArrayList<Student> students = new ArrayList<Student>();
	
public DATA() {
	}
	
	//courses and students serialized
	public static void serialize() {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("courses.ser");
			ObjectOutputStream objOutputStream = new ObjectOutputStream(fileOutputStream);
			
			objOutputStream.writeObject(courses);
			fileOutputStream.close();
			objOutputStream.close();
			System.out.println("Serialization complete: courses");
			
			
			fileOutputStream = new FileOutputStream("students.ser");
			objOutputStream = new ObjectOutputStream(fileOutputStream);
			objOutputStream.writeObject(students);
			fileOutputStream.close();
			objOutputStream.close();
			
			System.out.println("Serialization complete: students");
			System.out.println("\n");
			System.out.println("\n");

			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//deserialize students and courses
	@SuppressWarnings("unchecked")
	public static void deserialize() {
		try {
			FileInputStream fileInput = new FileInputStream("courses.ser");
		    ObjectInputStream objInput = new ObjectInputStream(fileInput);
		    
		    courses = (ArrayList<Course>) objInput.readObject();
		    
		    fileInput.close();
		    objInput.close();
		    
		    System.out.println("Deserialization complete: courses");
		    
		    fileInput = new FileInputStream("students.ser");
		    objInput = new ObjectInputStream(fileInput);
		    
		    
		    
		    students = (ArrayList<Student>) objInput.readObject();
		    
		    fileInput.close();
		    objInput.close();
		    
		    System.out.println("Deserialization complete: students");
		} catch (FileNotFoundException e) { 
			System.out.println("Importing");
			importCSV();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//parse the csv file as string on each line, split by "," store data by columns of category
	public static void importCSV() {
		try {
			Scanner scan = new Scanner(new File("MyUniversityCourses.csv"));
			
			scan.nextLine();
			
			while (scan.hasNextLine()) {
				String temp = scan.nextLine();
				String[] lineText = temp.split(",");
				
				courses.add(new Course(lineText[0],lineText[1],Integer.parseInt(lineText[2]),lineText[5],
						Integer.parseInt(lineText[6]),lineText[7]));
				
				
			}
			
			scan.close();
			
			System.out.println("Data imported from MyUniversityCourses.csv");
		} catch (FileNotFoundException e) { 
			System.out.println("CSV file not found");
		}
	}

}
