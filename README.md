# Course Registration System
This application simulates a course registration system for a university.

## Design
Here I will talk about the overall design of this application.

### Interfaces
This application has two interfaces, one for the Admin class (AdminInterface) and one for the Student class (StudentInterface).  Both interfaces work directly with their respective classes in the sense that the interfaces hold the method signatures for methods that they want to be implemented in the classes which implement the interfaces.

### Classes
In addition to the two interaces, this application contiains fives classes: User, Admin,  Student, Course,  and Main.

#### User
This is the super class for Admin and Student.  It is the base design for what it means to be a user in the Course Registration System.  This class provides the Admin and Student classes with the necesary instance variables to be inherited so that the Admin and Student experience while using the Course Registration System is as smoothe as possible.

#### Admin
The Admin class extends the User class and works very closely with each other class in the application.  Admin has complete administrative control over the course registration system.  The Admin can create, delete, and edit courses in the system.  Admin can also register other student's for the system giving them a username and password to login with.  The Admin class also implements `java.io.Serializable`, due to the fact that at the end of the program some data containing Admin class objects is serialized to be used later.  An important aspect to note is that if the Admin deletss a course from the system, it does NOT delete the course from a Student object's `courses` instance variable, the student will be required to do it themselves.

#### Course
The Course class represents the courses which are stored, edited, created, and deleted by the Admin class.  The Course class also works very closely with the Student class because when students register for a course, the Course object add's a student obect to an `ArrayList<Student>` instance variable which stores the students registered in the course.

#### Main
This class brings everything together.

## Getting Started
For initial use please login with Admin acces:
Username: `Admin`
Password: `Admin001`

Then follow the prompts as given.  `-help` can be used to view the commands that Admin and Student users have.  Note that student users are not accessible until the Admin runs `-register` and follows the prompts.
