package data.structures.jsd410;

import java.util.ArrayList;

/**
 * This is an interface for the Admin class.
 * @author juliansmithdeniro
 * @version 1.0
 */

public interface AdminInterface {
	
	/**
	 * Initialize a new course object to be stored in the system 
	 * using the parameters specified by the Admin.
	 * @param courseName is a String representing the name of the new course object.
	 * @param courseID is a String representing the ID of the new course object.
	 * @param maxNumOfStudents is an int representing the max number of students
	 * allowed in the course of the new course object.
	 * @param courseInstructor is a String representing the name of the instructor of the course.
	 * @param sectionNumber is an int representing the section of the new course if there is more than one with the same name.
	 * @param courseLocation is a String representing the location at which the new course will take place.
	 * @return
	 */
	public Course createCourse(
			String courseName, String courseID,
			int maxNumOfStudents, String courseInstructor,
			int sectionNumber, String courseLocation);
	
	/**
	 * Delete the specified course from the system.
	 * NOTE: This method does not in turn delete the course from each Student object's
	 * ArrayList<Course> courses instance variable.
	 * This will have to be done by the students themselves for the time being.
	 * @param courses is an ArrayList<Course> which contains the course objects registered in the system.
	 * @param users is an ArrayList<User> which contains the user objects registered in the system.
	 */
	public void deleteCourse(ArrayList<Course> courses, ArrayList<User> users);
	
	/**
	 * Edit the specified course object's instance variables such as
	 * course name, course id, section number, etc.
	 * @param course is a Course object which is going to be edited by the Admin.
	 * @return the new edited Course object to replace the old Course object.
	 */
	public Course editCourse(Course course);
	
	/**
	 * Show specified course's info such as course name, id, section number, etc.
	 * @param courses is an ArrayList<Course> to be iterated over in the search for
	 * the Admin's specified course that they want to edit.
	 */
	public void showCourseInfo(ArrayList<Course> courses);
	
	/**
	 * Register a new Student user with a first name, last name, username, and password to the system.
	 * @param users is an ArrayList<User> containing the user objects registered in the system.
	 */
	public void registerStudent(ArrayList<User> users);
	
	/**
	 * Display the list of students in the specified course.
	 * @param courses an ArrayList<Course> which contains all the registered courses in the system.
	 */
	public void viewStudentsInCourse(ArrayList<Course> courses);
	
	/**
	 * Display the specified student's courses that they are registered for.
	 * @param users an ArrayList<User> containing all the registered users in the system.
	 */
	public void viewStudentCourses(ArrayList<User> users);
	
	/**
	 * Display all courses to the console and all of their information.
	 * @param courses an ArrayList<Course> containing all the registered courses in the system.
	 */
	public void viewAllCourses(ArrayList<Course> courses);
	
	/**
	 * Display all the full courses to the console.
	 * @param courses an ArrayList<Course> containing all the registered courses in the system.
	 */
	public void viewAllFullCourses(ArrayList<Course> courses);
	
	/**
	 * Write all the full courses to a text file write under the project root directory.
	 * @param courses an ArrayList<Course> containing all the registered courses in the system.
	 */
	public void writeFullCoursesToTextFile(ArrayList<Course> courses);
	
	/**
	 * Sort the ArrayList<Course> containing the courses registered in the system by current number of students.
	 * @param courses an ArrayList<Course> containing all the registered courses in the system.
	 * @param low an int which should be 0 for best result.
	 * @param high an int which should be the length of the first parameter - 1 for best result.
	 */
	public void sort(ArrayList<Course> courses, int low, int high);
	
	/**
	 * Allow the current user set or edit the info on the account.
	 */
	public void setInfo();
}
