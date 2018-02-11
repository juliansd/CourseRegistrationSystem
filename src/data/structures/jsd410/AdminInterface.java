package data.structures.jsd410;

import java.util.ArrayList;

public interface AdminInterface {
	public Course createCourse(
			String courseName, String courseID,
			int maxNumOfStudents, String courseInstructor,
			int sectionNumber, String courseLocation);
	public void deleteCourse(ArrayList<Course> courses, ArrayList<User> users);
	public Course editCourse(Course course);
	public void showCourseInfo(ArrayList<Course> courses);
	public void registerStudent(ArrayList<User> users);
	public void viewStudentsInCourse(ArrayList<Course> courses);
	public void viewStudentCourses(ArrayList<User> users);
	public void viewAllCourses(ArrayList<Course> courses);
	public void viewAllFullCourses(ArrayList<Course> courses);
	public void writeFullCoursesToTextFile(ArrayList<Course> courses);
	public void sort(ArrayList<Course> courses, int low, int high);
	public void setInfo();
}
