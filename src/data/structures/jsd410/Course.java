package data.structures.jsd410;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class Course implements java.io.Serializable, Comparable<Course> {
	private String courseName;
	private String courseID;
	private int maxNumOfstudents;
	private int currentNumOfstudents;
	private ArrayList<Student> students = new ArrayList<Student>();
	private String courseInstructor;
	private int sectionNumber;
	private String courseLocation;
	
	public Course() {
	}
	
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

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public int getMaxNumOfstudents() {
		return maxNumOfstudents;
	}

	public void setMaxNumOfstudents(int maxNumOfstudents) {
		this.maxNumOfstudents = maxNumOfstudents;
	}

	public int getCurrentNumOfstudents() {
		return currentNumOfstudents;
	}

	public void setCurrentNumOfstudents(int currentNumOfstudents) {
		this.currentNumOfstudents = currentNumOfstudents;
	}

	public ArrayList<Student> getStudents() {
		return students;
	}

	public void addStudent(Student student) {
		this.students.add(student);
	}

	public String getCourseInstructor() {
		return courseInstructor;
	}

	public void setCourseInstructor(String courseInstructor) {
		this.courseInstructor = courseInstructor;
	}

	public int getSectionNumber() {
		return sectionNumber;
	}

	public void setSectionNumber(int sectionNumber) {
		this.sectionNumber = sectionNumber;
	}

	public String getCourseLocation() {
		return courseLocation;
	}

	public void setCourseLocation(String courseLocation) {
		this.courseLocation = courseLocation;
	}
	 
	public boolean equals(Course course) {
		if (this.getCourseID().equals(course.getCourseID())) {
			return true;
		}
		return false;
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
	
	public void removeStudent(Student student) {
		ArrayList<Student> studentList = this.getStudents();
		if (studentList.contains(student)) {
			studentList.remove(student);
		}
	}

}