package com.coderscampus;

import java.util.Arrays;
import java.util.Comparator;

//Main method, responsible for coordinating the reading, processing, sorting and writing of data. 

public class CourseManager {

	public static void main(String[] args) {
		CSVReader csvReader = new CSVReader(); 
		Student [] masterList = csvReader.readCSV("masterlist.csv"); //read student data from CSV file and store them in an a array.
		System.out.println("master List: ");
		System.out.println(Arrays.toString(masterList));
		
		//Line here toll 33, hard code it. 
		//count number of students in each class
//		Integer countCourse1 = 0; //CompSci 34
//		Integer countCourse2 = 0; //Stat 33
//		Integer countCourse3 = 0; //Apmth 33
//
//		for(Student student : masterList) { //This line starts a loop that iterates through each 'student' in the 'masterList' file.
//			if (student != null) {//This checks if the current 'student' object is not null and is a valid student data.
//				if ("COMPSCI".contains(student.getCourse())) { //If the students course is 'COMPSCI' we increment the countCourse1 variable by 1.
//					countCourse1++; //If student is enrolled in class, the line increments the 'countcourse' variable
//				} else if ("STAT".contains(student.getCourse())) {
//					countCourse2++;
//				}else if ("APMTH".contains(student.getCourse())) {
//					countCourse3++;
//				}
//			}
//		}
		
		//create arrays to store students for each course 
		Student [] course1Students = new Student[34];
		Student [] course2Students = new Student[33]; //Change to exact number.
		Student [] course3Students = new Student[33];
		
		//Distribute student into the arrays based on their course 
		Integer indexCourse1 = 0;
		Integer indexCourse2 = 0;
		Integer indexCourse3 = 0;
		
		for (Student student : masterList) { //Iterates through each 'student' object in the 'masterlist' array.
			if (student != null) {
				if( "COMPSCI".contains(student.getCourse())) { //checks if the course of the current student is 'COMPSCI'
					course1Students[indexCourse1] = student;
					++indexCourse1;
				} else if("STAT".contains(student.getCourse())) {
					course2Students[indexCourse2] = student;
					++indexCourse2;
				} else if ("APMTH".contains(student.getCourse())) {
					course3Students[indexCourse3] = student;
					++indexCourse3;
				}
			}
		}
//		System.out.println(Arrays.toString(course1Students));
	    System.out.println("Course 1 Students:");
	    System.out.println(Arrays.toString(course1Students));
	    System.out.println("Course 2 Students:");
	    System.out.println(Arrays.toString(course2Students));
	    System.out.println("Course 3 Students:");
	    System.out.println(Arrays.toString(course3Students));
		
		//These lines sort each array of students based on their grade in descending order. 
		//'.reversed' reverses natural older of comparison, so it sorts it in descending order.
		Arrays.sort(course1Students, Comparator.comparingInt(Student::getGrade).reversed());
		Arrays.sort(course2Students, Comparator.comparingInt(Student::getGrade).reversed());
		Arrays.sort(course3Students, Comparator.comparingInt(Student::getGrade).reversed());
		
		//write sorted student arrays to CSV files. 
		CSVWriter csvWriter = new CSVWriter();
		csvWriter.writerCSV("course1.csv", course1Students);
		csvWriter.writerCSV("course2.csv", course2Students);
		csvWriter.writerCSV("course3.csv", course3Students);
	}
}





//List<Student> students = new ArrayList<>();
//
//try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
//    String line;
//    br.readLine(); // Skip header line
//    while ((line = br.readLine()) != null) {
//        String[] data = line.split(",");
//        String studentId = data[0];
//        String studentName = data[1];
//        String course = data[2];
//        String grade = data[3]; // Modified to String
//        students.add(new Student(studentId, studentName, course, grade));
//    }