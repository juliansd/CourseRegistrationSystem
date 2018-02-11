package data.structures.jsd410;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * This class is for the main functionality of the Course Registration System.
 * @author juliansmithdeniro
 *
 */

public class Main {
	
	/**
	 * This method serializes the courses array list to be used after the program has already been run once.
	 * @param courses is ArrayList for Courses objects which represent courses stored in the system.
	 */
	public static void serializeCourses(ArrayList<Course> courses) {
		
		System.out.println("Saving course data..");
		
		try {
			FileOutputStream fos = new FileOutputStream("src/serializedData/Courses.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(courses);
			
			oos.close();
			fos.close();
			
			System.out.println("Done.");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method follows suit with the method prior except for User objects.
	 * @param users is an ArrayList for User objects.
	 */
	
	public static void serializeUsers(ArrayList<User> users) {
		
		System.out.println("Saving user data..");
				
		try {
			FileOutputStream fos = new FileOutputStream("src/serializedData/Users.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			if (users.size() > 0) {
				oos.writeObject(users);
			}
			
			oos.close();
			fos.close();
			
			System.out.println("Done.");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Deserializes the course array list which is stored whenever the program terminates.
	 * @param path is a String which represents the path to the serialized object.
	 * @return the deserialized object which in this case is an ArrayList<Course>
	 */
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Course> deserializeCourses(String path) {
		
		ArrayList<Course> dc = null;
		
		try {
			FileInputStream fis = new FileInputStream("src/serializedData/Courses.ser");
			
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			dc = (ArrayList<Course>)ois.readObject();
			
			ois.close();
			
			return dc;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Follows suit with the method prior except for User objects.
	 * @param path to serialized User object.
	 * @return an ArrayList<User> which represents the users in the system.
	 */
	
	@SuppressWarnings("unchecked")
	public static ArrayList<User> deserializeUsers(String path) {
			
			ArrayList<User> du = null;
			
			try {
				FileInputStream fis = new FileInputStream("src/serializedData/Users.ser");
				
				ObjectInputStream ois = new ObjectInputStream(fis);
				
				du = (ArrayList<User>)ois.readObject();
				
				ois.close();
				
				return du;
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				return null;
			}
		}
	
	/**
	 * Method which runs if the program detects that an Admin type user successfully logs in.
	 * @param users an ArrayList which represents the users stored in the system.
	 * @param courses an ArrayList which represents the courses stored in the system.
	 */
	
	public static void adminLogin(ArrayList<User> users, ArrayList<Course> courses) throws InputException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Password:\t");
		String password = scan.nextLine();
		if (password.equals("Admin001")) {
			System.out.println("Sucessful login.\n"
					+ "For a list of commands type -help.\n"
					+ "To exit the program type -exit.\n");
			Admin admin = new Admin("Admin", "1", "Admin", "Admin001");
			users.add(admin);
			String command;
			while (true) {
				
				command = scan.nextLine();
				
				if (command.equals("-help")) {
					admin.help();

				} else if (command.equals("-mkcourse")) {
					System.out.println("Give input for the specified fields:");
					System.out.println("Course name:");
					String courseName = scan.nextLine();
					System.out.println("Couse ID:");
					String courseID = scan.nextLine();
					System.out.println("Course instructor:");
					String courseInstructor = scan.nextLine();
					System.out.println("Course location:");
					String courseLocation = scan.nextLine();
					System.out.println("Section number:");
					int sectionNumber = scan.nextInt();
					System.out.println("Maximum number of students:");
					int maxNumOfStudents = scan.nextInt();
					
					Course newCourse = admin.createCourse(
							courseName, courseID, maxNumOfStudents, courseInstructor,
							sectionNumber, courseLocation);
					courses.add(newCourse);
					
					System.out.println("Course created.");

				} else if (command.equals("-delcourse")) {
					admin.deleteCourse(courses, users);

				} else if (command.equals("-chcourse")) {
					System.out.println(
							"Please enter the COURSE NAME, COURSE ID, and SECTION NUMBER "
							+ "of the course you would like to edit.\n"
							+ "Course name:\t");
					String courseNameToEdit = scan.nextLine();
					System.out.println("Course ID: ");
					String courseIDToEdit = scan.nextLine();
					System.out.println("Section number: ");
					int sectionNumberToEdit = scan.nextInt();
					for (Course course : courses) {
						if (
								course.getCourseName().equals(courseNameToEdit) &&
								course.getCourseID().equals(courseIDToEdit) &&
								course.getSectionNumber() == sectionNumberToEdit) {
							admin.editCourse(course);
							System.out.println("Course edit successful.");
						} else {
							System.err.println("Could not find specified course.");
						}
					}

				} else if (command.equals("-showcourse")) {
					admin.showCourseInfo(courses);

				} else if (command.equals("-register")) {
					admin.registerStudent(users);

				} else if (command.equals("-viewall")) {
					admin.viewAllCourses(courses);
					
				} else if (command.equals("-viewfull")) {
					admin.viewAllFullCourses(courses);

				} else if (command.equals("-writefull")) {
					admin.writeFullCoursesToTextFile(courses);
					
				} else if (command.equals("-viewroster")) {
					admin.viewStudentsInCourse(courses);
					
				} else if (command.equals("-viewstudent")) {
					admin.viewStudentCourses(users);
					
				} else if (command.equals("-sort")) {
					System.out.println("Sorting...");
					admin.sort(courses, 0, courses.size() - 1);
					System.out.println("Done.");
					
				} else if (command.equals("-exit")) {
					System.out.println("System exiting...");
					serializeCourses(courses);
					serializeUsers(users);
					break;
				} else {
					if (!command.equals("")) {
						System.err.println("Command not found.");
					}
				}
			}
		} else {
			System.out.println("Incorrect username or password.");
		}
	}
	
	/**
	 * Follows suit to the method prior except for a Student type User.
	 * @param student is the student object which is created by the Admin.
	 * @param users an ArrayList which represents the users in the system.
	 * @param courses an ArrayList which represents the courses in the system.
	 */
	
	public static void studentLogin(Student student, ArrayList<User> users, ArrayList<Course> courses) throws InputException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Password:\t");
		String password = scan.nextLine();
		if (password.equals(student.getPassword())) {
			System.out.println("Sucessful login.\n" +
					"For a list of commands type -help.\n"
					+ "To exit the program type -exit.\n");
			while(true) {
				
				String command = scan.nextLine();
				
				if (command.equals("-help")) {
					student.help();
					
				} else if (command.equals("-viewall")) {
					student.viewAllCourses(courses);
					
				} else if (command.equals("-viewopen")) {
					student.viewAvailableCourses(courses);
					
				} else if (command.equals("-register")) {
					student.register(courses);
					
				} else if (command.equals("-withdraw")) {
					System.out.println("Please enter the COURSE NAME, COURSE ID, and SECTION NUMBER "
							+ "that you would like to withdraw from.");
					System.out.println("Course name: ");
					String courseName = scan.nextLine();
					System.out.println("Course ID:");
					String courseID = scan.nextLine();
					System.out.println("Section number: ");
					int sectionNumber = scan.nextInt();
					student.withdraw(courseName, courseID, sectionNumber);
			
				} else if (command.equals("-myclasses")) {
					student.viewAllCurrentCourses();
					
				} else if (command.equals("-exit")) {
					System.out.println("System exiting...");
					serializeCourses(courses);
					serializeUsers(users);
					break;
					
				} else {
					System.out.println("Command not found.");
				}
			}
			
		} else {
			System.out.println("Incorrect username or password.");
		}
	}
	
	public static void main(String[] args) {
		
		ArrayList<Course> courses;
		ArrayList<User> users;

		if (!new File("src/serializedData/Courses.ser").exists() &&
				!new File("src/serializedData/Courses.ser").exists()) {
			new File("src/serializedData").mkdir();
			
			courses = new ArrayList<Course>();
			users = new ArrayList<User>();
			
			File courseData = new File("src/courseData.csv");
			try {
		        Scanner sc = new Scanner(courseData);
		        int n = 0;
		        while (sc.hasNextLine()) {
		            String line = sc.nextLine();
		            String[] data = line.split(",");
		            if (n != 0) {
		            		if (data[4] != "NULL") {
		            			Course courseObject = new Course(
		            				data[0], data[1], Integer.parseInt(data[2]),
		            				data[5], Integer.parseInt(data[6]), data[7]);
		            			courses.add(courseObject);
		            		}
		            }
		            n += 1;
		        }
		        sc.close();
		    }
		    catch (FileNotFoundException e) {
		        e.printStackTrace();
		    }
		} else {
			
			courses = deserializeCourses("src/serializedData/Courses.ser");
			users = deserializeUsers("src/serializedData/Users.ser");
		}
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("Welcome to the Univeristy Course Registration System.\n"
					+ "Please enter your username and password.\n"
					+ "Username:\t");
			String username = scan.nextLine();
			if (username.equals("Admin")) {
				adminLogin(users, courses);
			} else {
				for (User user : users) {
					if (user.getUsername().equals(username)) {
						studentLogin((Student)user, users, courses);
					}
				}
			}
		} catch (InputException e) {
			e.printStackTrace();
		}
	}
	
}
