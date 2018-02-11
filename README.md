# Course Registration System
This application simulates a course registration system for a university.

#### Table of Contents
[Design](https://github.com/juliansd/CourseRegistrationSystem#design)
* [Workflow](https://github.com/juliansd/CourseRegistrationSystem#workflow)
* [Interfaces](https://github.com/juliansd/CourseRegistrationSystem#interfaces)
* [Classes](https://github.com/juliansd/CourseRegistrationSystem#classes)
    * [User](https://github.com/juliansd/CourseRegistrationSystem#user)
    * [Admin](https://github.com/juliansd/CourseRegistrationSystem#admin)
    * [Course](https://github.com/juliansd/CourseRegistrationSystem#course)
    * [Main](https://github.com/juliansd/CourseRegistrationSystem#main)
    
[Concepts](https://github.com/juliansd/CourseRegistrationSystem#concepts)
* [Overloading](https://github.com/juliansd/CourseRegistrationSystem#overloading)
* [Overriding](https://github.com/juliansd/CourseRegistrationSystem#overriding)
* [Abstract Class](https://github.com/juliansd/CourseRegistrationSystem#abstract-class)
* [Inheritance](https://github.com/juliansd/CourseRegistrationSystem#inheritance)
* [Polymorphism](https://github.com/juliansd/CourseRegistrationSystem#polymorphism)
* [Encapsulation](https://github.com/juliansd/CourseRegistrationSystem#encapsulation)
* [ADT (Abstract Data Types)](https://github.com/juliansd/CourseRegistrationSystem#adt-(abstract-data-types))

[Getting Started](https://github.com/juliansd/CourseRegistrationSystem#getting-started)

## Design
Here I will talk about the overall design of this application.

### Workflow
When the application starts it checks to see if there exists a file called `Courses.ser` which is the serialized file of an `ArrayList<Course>` of course objects registered in the system.  If it exists, then the program deserializes the file and stores it in an `ArrayList<Course>` which represents all the courses currently registered in the system and which is to be used throughout the running of the application and restored when the program terminates.  (NOTE: If the program ends abruptly without a proper termination, [using the `-exit` command] whatever changes were made prior will NOT be saved.)  The user will be prompted to log in and asked for a username and password.  Based on that input the application will launch the user menu for either the Admin or Student user.  Then a while loop is executed within the respective user menu methods which doesn't break until the user uses the command `-exit` at which point the application serializes the `ArrayList<Course>` and `ArrayList<User>`.

### Interfaces
This application has two interfaces, one for the Admin class (AdminInterface) and one for the Student class (StudentInterface).  Both interfaces work directly with their respective classes in the sense that the interfaces hold the method signatures for methods that they want to be implemented in the classes which implement the interfaces.

### Classes
In addition to the two interaces, this application contiains fives classes: User, Admin,  Student, Course,  and Main.

#### User
This is the super class for Admin and Student.  It is the base design for what it means to be a user in the Course Registration System.  This class provides the Admin and Student classes with the necesary instance variables to be inherited so that the Admin and Student experience while using the Course Registration System is as smoothe as possible.  It also allows for constructors to be inherited by the Admin and Student class which instantiate these objects with the specified parameters rather than doing it after instantiation.

#### Admin
The Admin class extends the User class and works very closely with each other class in the application.  Admin has complete administrative control over the course registration system.  The Admin can create, delete, and edit courses in the system.  Admin can also register other student's for the system giving them a username and password to login with.  The Admin class also implements `java.io.Serializable`, due to the fact that at the end of the program some data containing Admin class objects is serialized to be used later.  An important aspect to note is that if the Admin deletss a course from the system, it does NOT delete the course from a Student object's `courses` instance variable, the student will be required to do it themselves.

#### Student
The Student class also extends the User class and works closely with the Admin and Course classes.  Student has less control over the system than Admin, but is able to view, register, and withdraw from the courses offered in the system, as well as view the courses under specific parameters.  And just like Admin, Student implements `java.io.Serializable` because when a Student object is instantiated by the Admin command `-register`, the object is stored in `ArrayList<User> users` which is then serialized at the end of the application into a file called `Users.ser`.

#### Course
The Course class represents the courses which are stored, edited, created, and deleted by the Admin class.  The Course class also works very closely with the Student class due to the fact that when students register for a course, the Course object adds a student obect to an `ArrayList<Student>` instance variable which stores the students registered in the course.  Each course object has multiple parameters which are accessed by the Admin and Student classes to add, edit, or delete courses in the system.  The one's that are used the most when working with the Course class are: <Enter>
```
String courseName
String courseID
int sectionNumber
```
This class also implements `java.io.Serializable` because when a Course object is instantiated it is added to `ArrayList<Course> courses` which stores all the courses in the system and serializes them when the user decides to exit the program.  The data is stored into a file called `Courses.ser`.

#### Main
The Main class is the one that connects all the other classes.  It essentially runs the main functionality of the application as well as is responsible for the serialization and deserialization of the Course and User object data.

## Concepts

### Overloading
### Overriding
### Abstract Class
### Inheritance
### Polymorphism
### Encapsulation
### ADT (Abstract Data Types)

## Getting Started
For initial use please login with Admin acces:
Username: `Admin`
Password: `Admin001`

Then follow the prompts as given.  `-help` can be used to view the commands that Admin and Student users have.  Note that student users are not accessible until the Admin runs `-register` and follows the prompts.
