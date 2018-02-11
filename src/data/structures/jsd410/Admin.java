package data.structures.jsd410;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class represents that of the Admin user which in this system
 * there is only one of and has administrative capabilities over the system.
 * It also implements the interface AdminInterface and java.io.Serializable 
 * o be serialized when the program terminates
 * @author juliansmithdeniro
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Admin extends User implements AdminInterface, java.io.Serializable {
	
	/**
	 * Scanner which is passed when object is initialized to access user input.
	 */
	private static Scanner scan = new Scanner(System.in);

	/**
	 * Default constructor inherited from super class User.
	 */
	public Admin() {
		super(scan);
	}
	
	/**
	 * Constructor which allows for the object to be initialized with the specified parameters.
	 * @param username is a String representing the Admin's username to login with.  Default is Admin.
	 * @param password is a String representing the Admin's password to login with.  Default is Admin001.
	 * @param firstName is a String representing the Admin's first name.
	 * @param lastName is a String representing the Admin's last name.
	 */
	public Admin(String username, String password, String firstName, String lastName) {
		super(username, password, firstName, lastName, scan);
	}
	
	@Override
	public Course createCourse(String courseName, String courseID, int maxNumOfStudents, String courseInstructor,
			int sectionNumber, String courseLocation) {
		
		Course newCourse = new Course(
				courseName, courseID, maxNumOfStudents, courseInstructor, sectionNumber, courseLocation);
		
		newCourse.setCurrentNumOfstudents(0);
		
		return newCourse;
	}

	@Override
	public void deleteCourse(ArrayList<Course> courses, ArrayList<User> users) 
			throws InputMismatchException {
		System.out.println("Please enter the COURSE NAME, COURSE ID, and COURSE SECTION of the "
				+ "course you would like to delete.");
		System.out.println("Course name: ");
		String courseName = scan.nextLine();
		System.out.println("Course ID: ");
		String courseID = scan.nextLine();
		System.out.println("Course Section: ");
		int courseSection = scan.nextInt();
		for (int i = 0; i < courses.size(); i++) {
			if (
					courses.get(i).getCourseName().equals(courseName)
					&& courses.get(i).getCourseID().equals(courseID)
					&& courses.get(i).getSectionNumber() == courseSection) {
				for (User user : courses.get(i).getStudents()) {
					((Student) user).withdraw(
							courses.get(i).getCourseName(), courses.get(i).getCourseID(),
							courses.get(i).getSectionNumber());
				}
				courses.remove(courses.get(i));
				System.out.println("Course removed.");
				break;
			}
		}	
	}

	@Override
	public Course editCourse(Course course) {
		System.out.println("Please enter the changes you'd like to make,"
				+ "if you don't want to change the specified field just press enter.\n");
		System.out.println("Course Name:\t");
		String courseName = scan.nextLine();
		if (!courseName.equals("")) {
			course.setCourseName(courseName);
		}
		System.out.println("Course ID:\t");
		String courseID = scan.nextLine();
		if (!courseID.equals("")) {
			course.setCourseID(courseID);
		}
		System.out.println("Course Instructor:\t");
		String courseInstructor = scan.nextLine();
		if (!courseInstructor.equals("")) {
			course.setCourseInstructor(courseInstructor);
		}
		return course;
	}

	@Override
	public void registerStudent(ArrayList<User> users) {
		System.out.println("Please enter the full name, username,"
				+ "and a temporary password for the student you would like to register.");
		System.out.println("First name:");
		String firstName = scan.nextLine();
		System.out.println("Last name:");
		String lastName = scan.nextLine();
		System.out.println("Username:");
		String username = scan.nextLine();
		System.out.println("Password:");
		String password = scan.nextLine();
		
		Student newStudent = new Student(username, password, firstName, lastName);
		users.add(newStudent);
		
		System.out.println("Registration complete.");
	}

	@Override
	public void viewStudentsInCourse(ArrayList<Course> courses) {
		System.out.println("Enter the COURSE NAME, COURSE ID, and SECTION "
				+ "NUMBER you would like to view the roster for.");
		System.out.println("Course name: ");
		String courseName = scan.nextLine();
		System.out.println("Course ID: ");
		String courseID = scan.nextLine();
		System.out.println("Section number: ");
		int sectionNumber;
		try {
			sectionNumber = scan.nextInt();
			for (Course course : courses) {
				if (
						course.getCourseName().equals(courseName) &&
						course.getCourseID().equals(courseID) &&
						course.getSectionNumber() == sectionNumber) {
					ArrayList<Student> courseList = course.getStudents();
					System.out.println("Displaying the class roster for " + course.getCourseName() + ":");
					for (Student student : courseList) {
						System.out.println(student.getFirstName() + " " + student.getLastName());
					}
				}
			}
		} catch (InputMismatchException e) {
			e.printStackTrace();
			System.err.println(
					"Please make sure you enter a number for the Section prompt. Try again.");
		}
	}

	@Override
	public void viewStudentCourses(ArrayList<User> users) {
		System.out.println("Enter the user ID of the student:");
		String studentID = scan.nextLine();
		for (User user : users) {
			if (user instanceof Student) {
				if (((Student) user).getUsername().equals(studentID)) {
					ArrayList<Course> studentCourses = ((Student) user).getCourses();
					System.out.println(user.getFirstName() + " " + user.getLastName() + "'s Courses:\t");
					for (Course course : studentCourses) {
						System.out.println(course.getCourseName());
					}
				}
				
			}
		}
	}
	
	/**
	 * Method which outputs a list of commands that are executable by Admin while logged in.
	 */
	
	public void help() {
		System.out.printf(
				"%-150.150s%n %-150.150s%n %-150.150s%n %-150.150s%n %-150.150s%n %-150.150s%n "
				+ "%-150.150s%n %-150.150s%n %-150.150s%n %-150.150s%n %-150.150s%n %-150.150s%n ",
				"Course Registration System Admin Commands:\n",
				"-mkcourse:\tCreate a new course for students to register for.\n",
				"-delcourse:\tDelete a course from the Admin's course list.\n",
				"-chcourse:\tChange the specified course's info (name, course id, and " +
				"instructor).\n",
				"-showcourse:\tDisplays the specified course's info\n",
				"-register:\tRegister the specified student for a course\n",
				"-viewall:\tDisplay all courses and their information registered in the Course " +
				"Registration System\n",
				"-viewallfull:\tDisplay all the courses which are full.\n",
				"-writefull:\tWrite list of full courses to a text file in the " +
				"specified directory.\n",
				"-showflass:\t Display a list of currently registered students in the " +
				"specified class.\n",
				"-display:\t Will display the specifed student's registered classes " +
				"for the semester.\n",
				"-exit:\tExit's the program.");
	}

	@Override
	public void showCourseInfo(ArrayList<Course> courses) {
		System.out.println("Please enter the course id of the class you want to view:");
		String courseID = scan.nextLine();
		for (Course course : courses) {
			if (courseID.equals(course.getCourseID())) {
				System.out.printf("%-30.30s  %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s%n", 
						"Course name","Course ID", "Maximum # of Students", "Current # of Students",
						"Course Instructor", "Section number","Course location");
				System.out.printf("%-30.30s  %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s%n",
						course.getCourseName(), course.getCourseID(),
						course.getMaxNumOfstudents(), course.getCurrentNumOfstudents(),
						course.getCourseInstructor(), course.getSectionNumber(),
						course.getCourseLocation());
				ArrayList<Student> students = course.getStudents();
				System.out.println("");
				System.out.printf("%-30.30s%n", "Students");
				for (Student student : students) {
					System.out.printf("%-30.30s%n",student.getFirstName() + " " + student.getLastName());
				}
			}
		}
	}

	@Override
	public void viewAllCourses(ArrayList<Course> courses) {
		System.out.printf("%-30.30s  %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s%n", 
				"Course name","Course ID", "Maximum # of Students", "Current # of Students",
				"Course Instructor", "Section number","Course location");
		for (Course course : courses) {
			System.out.printf("%-30.30s  %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s%n",
					course.getCourseName(), course.getCourseID(),
					course.getMaxNumOfstudents(), course.getCurrentNumOfstudents(),
					course.getCourseInstructor(), course.getSectionNumber(), course.getCourseLocation());
		}
	}
	
	@Override
	public void viewAllFullCourses(ArrayList<Course> courses) {
		System.out.println("Course name\tCourse ID\t"
				+ "Course Instructor\tSection number\tCourse location");
		for (Course course : courses) {
			if (course.getCurrentNumOfstudents() == course.getMaxNumOfstudents()) {
				System.out.println(
						course.getCourseName() + "\t" + course.getCourseID() + "\t" + 
						course.getCourseInstructor() + "\t" + course.getSectionNumber() + 
						"\t" + course.getCourseLocation());
			}
		}
		
	}

	@Override
	public void writeFullCoursesToTextFile(ArrayList<Course> courses) {
		String fileName = "fullCourses.txt";
		try {
			FileWriter fileWriter = new FileWriter(fileName);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			for (Course course : courses) {
				if (course.getCurrentNumOfstudents() == course.getMaxNumOfstudents()) {
					bufferedWriter.write(course.getCourseName() + "\t" + course.getCourseID() + "\t" + 
						course.getCourseInstructor() + "\t" + course.getSectionNumber() + 
						"\t" + course.getCourseLocation() + "\n");
				}
			}
			System.out.println("Written to fullCourses.txt");
			bufferedWriter.close();
			
		} catch (IOException e) {
			System.out.println(
	                "Error writing to file '"
	                + fileName + "'");
		}
	}

	@Override
	public void sort(ArrayList<Course> courses, int low, int high) {
		if (low < high) {
			int indexOfMin = low;
			Course min = courses.get(low);
			for (int i = low + 1; i <= high; i++) {
				if (courses.get(i).compareTo(min) == -1) {
					min = courses.get(i);
					indexOfMin = i;
				}
			}
			
			courses.set(indexOfMin, courses.get(low));
			courses.set(low, min);
			
			sort(courses, low + 1, high);
			
		}
	}

	@Override
	public void setInfo() {
		System.out.println("Please enter the first and last"
				+ "name that you would like to register for this account.");
		System.out.println("First name:");
		String firstName = scan.nextLine();
		System.out.println("Last name:");
		String lastName = scan.nextLine();
		this.setFirstName(firstName);
		this.setLastName(lastName);
	}
}
