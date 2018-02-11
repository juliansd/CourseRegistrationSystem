package data.structures.jsd410;

import java.util.ArrayList;

public interface StudentInterface {
	public void viewAllCourses(ArrayList<Course> courses);
	public void viewAvailableCourses(ArrayList<Course> courses);
	public void register(ArrayList<Course> courses);
	public void withdraw(String courseName, String courseID, int sectionNumber);
	public void viewAllCurrentCourses();
	public void help();
}
