package data.structures.jsd410;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class which represents a Student and inherits from it's super class User.
 * The class is used to represent the students to be registered in courses on the system.
 * It also implements the interface StudentInterface and java.io.Serializable 
 * o be serialized when the program terminates
 * @author juliansmithdeniro
 * @version 1.0
 *
 */
@SuppressWarnings("serial")
public class Student extends User implements StudentInterface, java.io.Serializable {

	/**
	 * Scanner which is passed when object is initialized to access user input.
	 */
	private static Scanner scan = new Scanner(System.in);
	
	/**
	 * ArrayList<Course> which represents the courses that the student is registered for.
	 */
	private ArrayList<Course> courses = new ArrayList<Course>();

	/**
	 * Default constructor inherited from super class User.
	 */
	public Student() {
		super(scan);
	}
	
	/**
	 * Constructor which allows the object instantiated with the specified parameters.
	 * @param username a String representing the username of the Student object.
	 * @param password a String representing the password of the Student object.
	 * @param firstName a String representing the first name of the Student object.
	 * @param lastNamea String representing the last name of the Student object.
	 */
	public Student(String username, String password, String firstName, String lastName) {
		super(username, password, firstName, lastName, scan);
	}

	@Override
	public void viewAllCourses(ArrayList<Course> courses) {
		System.out.println("Courses offered this semester:");
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
	public void viewAvailableCourses(ArrayList<Course> courses) {
		System.out.println("Open Courses:");
		System.out.printf("%-30.30s  %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s%n", 
				"Course name","Course ID", "Maximum # of Students", "Current # of Students",
				"Course Instructor", "Section number","Course location");
		for (Course course : courses) {
			if (course.getCurrentNumOfstudents() < course.getMaxNumOfstudents()) {
				System.out.printf("%-30.30s  %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s%n",
						course.getCourseName(), course.getCourseID(),
						course.getMaxNumOfstudents(), course.getCurrentNumOfstudents(),
						course.getCourseInstructor(), course.getSectionNumber(), course.getCourseLocation());
				
			}
		}
		
	}

	@Override
	public void withdraw(String courseName, String courseID, int sectionNumber) {
		for (int i = 0; i < this.getCourses().size(); i++) {
			if (
					this.getCourses().get(i).getCourseName().equals(courseName) &&
					this.getCourses().get(i).getCourseID().equals(courseID) &&
					this.getCourses().get(i).getSectionNumber() == sectionNumber) {
				System.out.println(
						this.getFirstName() + " " + this.getLastName() + 
						" is no longer registered in " + this.getCourses().get(i).getCourseName());
				this.getCourses().remove(i);
				break;
			}
		}
		
	}

	@Override
	public void viewAllCurrentCourses() {
		System.out.println("Displaying courses currently registered in:");
		for (Course course : this.getCourses()) {
			System.out.println(course.getCourseName());
		}
		
	}

	@Override
	public void register(ArrayList<Course> courses) {
		System.out.println("Please enter the course name, section, "
				+ "and id, that you would like to register for.");
		System.out.println("Course name:");
		String courseName = scan.nextLine();
		if (courseName.equals("")) {
			System.out.println("There was an error.  Please re-enter the course name:");
			courseName = scan.nextLine();
			System.out.println("Course ID:");
			String courseID = scan.nextLine();
			System.out.println("Section:");
			int courseSection;
			try {
				courseSection = scan.nextInt();
				int n = courses.size();
				for (Course course : courses) {
					n--;
					if (
							course.getCourseName().equals(courseName) && 
							course.getSectionNumber() == courseSection && 
							course.getCourseID().equals(courseID) && 
							!(course.getMaxNumOfstudents() == course.getCurrentNumOfstudents())) {
						course.addStudent(this);
						this.courses.add(course);
						System.out.println("Registration complete.");
						break;
					}
				}
				if (n == 0) {
					System.out.println("Could not find specified course.");
				}
			} catch (InputMismatchException e) {
				e.printStackTrace();
				System.err.println(
						"Please make sure to enter a number for the Course section prompt.  "
						+ "Try again.");
			}
		} else {
			System.out.println("Course ID:");
			String courseID = scan.nextLine();
			System.out.println("Section:");
			int courseSection;
			try {
				courseSection = scan.nextInt();
				int n = courses.size();
				for (Course course : courses) {
					n--;
					if (
							course.getCourseName().equals(courseName) && 
							course.getSectionNumber() == courseSection && 
							course.getCourseID().equals(courseID) && 
							!(course.getMaxNumOfstudents() == course.getCurrentNumOfstudents())) {
						course.addStudent(this);
						this.courses.add(course);
						System.out.println("Registration complete.");
						break;
					}
				}
				if (n == 0) {
					System.out.println("Could not find specified course.");
				}
			} catch (InputMismatchException e) {
				e.printStackTrace();
				System.err.println(
						"Please make sure to enter a number for the Course section prompt.  "
						+ "Try again.");
			}
		}
		
	}

	public void help() {
		System.out.printf("%-30.200s%n %-30.200s%n %-30.200s%n %-30.200s%n %-30.200s%n %-30.200s%n %-30.200s%n",
				"-viewall:\tView all courses that are available.\n",
				"-viewopen:\tView all NOT full courses.\n",
				"-register:\tRegister for an open course.\n",
				"-withdraw:\tWithdraw from a course currrently registered in.\n",
				"-myclasses:\tView your currently registered classes.\n",
				"-exit:\tExit the system entirely.\n",
				"-help:\tView list of student commands.");
	}

	/**
	 * Getter for student courses instance variable.
	 * @return an ArrayList<Course> which represents the student's registered courses.
	 */
	public ArrayList<Course> getCourses() {
		return courses;
	}

	/**
	 * Setter for student courses instance variable.
	 * @param courses an ArrayList<Course> which represents the student's registered courses.
	 */
	public void setStudentCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}
	
}
