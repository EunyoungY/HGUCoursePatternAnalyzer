package edu.handong.analysis;

import edu.handong.analysis.datamodel.Course;
import edu.handong.analysis.datamodel.Student;

public class HGUCoursePatternAnalyzer {
	
	private String[] lines = {	"1999-1, JC Nam, Java Programming",
						"1999-2, JC Nam, Programming Language Theory",
						"1999-1, JC Nam, Data Structures",
						"2001-1, JC Nam, Database Systems",
						"2018-1, SB Lim, Java Programming",
						"2018-2, SB Lim, Programming Language Theory",
						"2019-1, SB Lim, Data Structures",
						"2019-1, SB Lim, Algorithm Analysis",
						"2018-1, SJ Kim, Java Programming",
						"2018-2, SJ Kim, Programming Language Theory",
						"2019-1, SJ Kim, Logic Design",
						"2019-1, SJ Kim, Algorithm Analysis",
						};

	private int numOfStudents;
	private int numOfCourses;
	private Student[] students; 
	private Course[] courses; 
	private int sCount=0;
	private int cCount=0;
	/**
	 * This method runs our analysis logic to get the list of student and course names from lines.
	 * @param args
	 */
	public void run(String[] args) {   
		numOfStudents = Integer.parseInt(args[0]);
		numOfCourses = Integer.parseInt(args[1]);
	
		students = initiateStudentArrayFromLines(lines);
		
		System.out.println("Number of All Students: " + numOfStudents);   
		for(Student student: students) {
			sCount++;
			if(studentExist(students, student) == false)
				System.out.println(student.getName()); 
		}
		 
		courses = initiateCourseArrayFromLines(lines);
		
		System.out.println("Number of All Courses: " + numOfCourses); 
		for(Course course: courses) {
			cCount++;
			if(courseExist(courses, course) == false)
				System.out.println(course.getCourseName());
		}
	}

	/**
	 * This method returns a Student array to initiate the field, students, from lines.
	 * @param lines
	 * @return
	 */ 
	private Student[] initiateStudentArrayFromLines(String[] lines) {   
		students = new Student[12];
		String[] aStudent;
		int i=0;
		for(String line: lines) {
			aStudent = line.split(", ");
			students[i++] = new Student(aStudent[1]);
		}   
		return students;
	}

	/**
	 * This method check if there is the same name of the second arugement in the array, students
	 * @param students
	 * @param student
	 * @return boolean
	 */
	private boolean studentExist(Student[] students, Student student) { 		 
		for(int i=0; i<sCount-1; i++) {
			if(students[i].getName().equals(student.getName())) 
				return true;
		} 
		return false;
	}
	
	/**
	 * This method returns a Course array to initiate the field, courses, from lines.
	 * @param lines
	 * @return
	 */
	private Course[] initiateCourseArrayFromLines(String[] lines) {   
		courses = new Course[12];
		String[] aCourse;
		int i=0;
		for(String line: lines) {
			aCourse = line.split(", ");
			courses[i++] = new Course(aCourse[2]);
		}
		return courses;
	}

	/**
	 * This method check if there is the same name of the second argument in the array, courses.
	 * @param courses
	 * @param course
	 * @return boolean
	 */
	private boolean courseExist(Course[] courses, Course course) {
		for(int i=0; i<cCount-1; i++) {
			if(courses[i].getCourseName().equals(course.getCourseName())) 
				return true;
		}   
		return false;
	}

}
