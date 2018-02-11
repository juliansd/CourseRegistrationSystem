package data.structures.jsd410;

import java.util.ArrayList;

/**
 * Interface for the Student class.
 * @author juliansmithdeniro
 * @version 1.0
 */
public interface StudentInterface {
	
	/**
	 * Display all the courses available for the semester to the console.
	 * @param courses an ArrayList<Course> representing the courses registered in the system.
	 */
	public void viewAllCourses(ArrayList<Course> courses);
	
	/**
	 * Display available courses for the semester which are NOT FULL to the console.
	 * @param courses an ArrayList<Course> representing the courses registered in the system.
	 */
	public void viewAvailableCourses(ArrayList<Course> courses);
	
	/**
	 * Register the current student for the specified course after following the prompts given by the console.
	 * @param courses an ArrayList<Course> representing the courses registered in the system.
	 */
	public void register(ArrayList<Course> courses);
	
	/**
	 * Withdraw the current student from the specified course.
	 * @param courseName a String representing the name of the course to be withdrawn from.
	 * @param courseID a String representing the ID of the course to be withdrawn from.
	 * @param sectionNumber an int representing the section number of the course to be withdrawn from.
	 */
	public void withdraw(String courseName, String courseID, int sectionNumber);
	
	/**
	 * Display all courses that the student is currently registered in.
	 */
	public void viewAllCurrentCourses();

}
