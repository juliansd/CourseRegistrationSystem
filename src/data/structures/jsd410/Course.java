package data.structures.jsd410;

import java.util.ArrayList;

/**
 * Class representing courses to be stored, created, edited, and deleted in the Course Registration System.
 * @author juliansmithdeniro
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Course implements java.io.Serializable, Comparable<Course> {
	
	/**
	 * String representing the Course object's name.
	 */
	private String courseName;
	
	/**
	 * String representing the course objects ID.
	 */
	private String courseID;
	
	/**
	 * int representing the course object's maximum number of students.
	 */
	private int maxNumOfstudents;
	
	/**
	 * int representing the course object's current number of student.
	 */
	private int currentNumOfstudents;
	
	/**
	 * ArrayList<Student> representing the course object's class roster.
	 */
	private ArrayList<Student> students = new ArrayList<Student>();
	
	/**
	 * String representing the course object's instructor.
	 */
	private String courseInstructor;
	
	/**
	 * int representing the course object's section number.
	 */
	private int sectionNumber;
	
	/**
	 * String representing the course object's location.
	 */
	private String courseLocation;
	
	/**
	 * Default constructor
	 */
	public Course() {
	}
	
	/**
	 * Instantiates a course object with the specified parameters.  
	 * The object's current number of students is always set to 0 on instantiation.
	 * @param courseName a String representing the course name.
	 * @param courseID a String representing the course ID.
	 * @param maxNumOfstudents an int representing the maximum number of students allowed in the course.
	 * @param courseInstructor a String representing the course instructor's name.
	 * @param sectionNumber an int representing the course's section number.
	 * @param courseLocation a String representing where the course is located.
	 */
	public Course(
			String courseName, String courseID, int maxNumOfstudents,
			String courseInstructor, int sectionNumber, String courseLocation) {

		setCourseName(courseName);
		setCourseID(courseID);
		setMaxNumOfstudents(maxNumOfstudents);
		setCourseInstructor(courseInstructor);
		setSectionNumber(sectionNumber);
		setCourseLocation(courseLocation);
		setCurrentNumOfstudents(0);
	}

	/**
	 * Getter for courseName.
	 * @return String which represents the course's name.
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * Setter for courseName
	 * @param courseName String which represents the course's name.
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 * Getter for courseID.
	 * @return String which represents the course's ID.
	 */
	public String getCourseID() {
		return courseID;
	}

	/**
	 * Setter for courseID.
	 * @param courseID String which represents the course's ID.
	 */
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	/**
	 * Getter for maxNumOfStudents.
	 * @return int which represents the course's maximum number of students.
	 */
	public int getMaxNumOfstudents() {
		return maxNumOfstudents;
	}

	/**
	 * Setter for maxNumOfstudents.
	 * @param maxNumOfstudents int which represents the course's maximum number of students.
	 */
	public void setMaxNumOfstudents(int maxNumOfstudents) {
		this.maxNumOfstudents = maxNumOfstudents;
	}

	/**
	 * Getter for currentNumOfStudents.
	 * @return int which represents the course's current number of students.
	 */
	public int getCurrentNumOfstudents() {
		return currentNumOfstudents;
	}

	/**
	 * Setter for currentNumOfStudents.
	 * @param currentNumOfstudents int which represents the course's current number of students.
	 */
	public void setCurrentNumOfstudents(int currentNumOfstudents) {
		this.currentNumOfstudents = currentNumOfstudents;
	}

	/**
	 * Getter for students ArrayList.
	 * @return ArrayList<Student> which represents the course's class list.
	 */
	public ArrayList<Student> getStudents() {
		return students;
	}

	/**
	 * Setter for students ArrayList.  Instead of setting a whole other ArrayList, it simply adds
	 * a student to the list.
	 * @param student ArrayList<Student> which represents the course's class list.
	 */
	public void addStudent(Student student) {
		this.students.add(student);
	}

	/**
	 * Getter for courseInstructor.
	 * @return String which represents the course's instructor.
	 */
	public String getCourseInstructor() {
		return courseInstructor;
	}

	/**
	 * Setter for courseInstructor.
	 * @param courseInstructor String which represents the course's instructor.
	 */
	public void setCourseInstructor(String courseInstructor) {
		this.courseInstructor = courseInstructor;
	}

	/**
	 * Getter for course's section number.
	 * @return int representing the course's section number.
	 */
	public int getSectionNumber() {
		return sectionNumber;
	}

	/**
	 * Setter for course's section number.
	 * @param sectionNumber int representing the course's section number.
	 */
	public void setSectionNumber(int sectionNumber) {
		this.sectionNumber = sectionNumber;
	}

	/**
	 * Getter for courseLocation.
	 * @return String representing the course's location.
	 */
	public String getCourseLocation() {
		return courseLocation;
	}

	/**
	 * Setter for courseLocation.
	 * @param courseLocation String representing the course's location.
	 */
	public void setCourseLocation(String courseLocation) {
		this.courseLocation = courseLocation;
	}

	@Override
	public int compareTo(Course course) {
		if (this.getCurrentNumOfstudents() > course.getCurrentNumOfstudents()) {
			return 1;
		} else if (this.getCurrentNumOfstudents() == course.getCurrentNumOfstudents()) {
			return 0;
		}
		return -1;
	}
	
	/**
	 * Removes a student from the students ArrayList.
	 * @param student a Student object representing a student registered in the course.
	 */
	public void removeStudent(Student student) {
		ArrayList<Student> studentList = this.getStudents();
		if (studentList.contains(student)) {
			studentList.remove(student);
		}
	}

}