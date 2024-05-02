package com.coderscampus;

import java.util.Arrays;
import java.util.Comparator;

//Main method, responsible for coordinating the reading, processing, sorting and writing of data. 

public class CourseManager {

	public static void main(String[] args) {
		CSVReader csvReader = new CSVReader(); 
		Student [] masterList = csvReader.readCSV("masterlist.csv"); //read student data from CSV file and store them in an a array.
		
		//count number of students in each class
		Integer countCourse1 = 0; //34
		Integer countCourse2 = 0; //33
		Integer countCourse3 = 0; //33
		
		for(Student student : masterList) { //This line starts a loop that iterates through each 'student' in the 'masterList' file.
			if (student != null) {//This checks if the current 'student' object is not null and is a valid student data.
				if ("COMPSCI".equals(student.getCourse())) { //If the students course is 'COMPSCI' we increment the countCourse1 variable by 1.
					countCourse1++; //If student is enrolled in class, the line increments the 'countcourse' variable
				} else if ("STAT".equals(student.getCourse())) {
					countCourse2++;
				}else if ("APMTH".equals(student.getCourse())) {
					countCourse3++;
				}
			}
		}
		
		//create arrays to store students for each course 
		Student [] course1Students = new Student[countCourse1];
		Student [] course2Students = new Student[countCourse2];
		Student [] course3Students = new Student[countCourse3];
		
		//Distribute student into the arrays based on their course 
		Integer indexCourse1 = 0;
		Integer indexCourse2 = 0;
		Integer indexCourse3 = 0;
		
		for (Student student : masterList) { //Iterates through each 'student' object in the ',asterlist' array.
			if (student != null) {
				if( "COMPSCI".equals(student.getCourse())) { //checks if the course of the current student is 'COMPSI'
					course1Students[indexCourse1++] = student;
				} else if("STAT".equals(student.getCourse())) {
					course2Students[indexCourse2++] = student;
				} else if ("APMTH".equals(student.getCourse())) {
					course3Students[indexCourse3++] = student;
				}
			}
		}
		
		//sort each array by grade in descending order
		//'Comparator.comparingInt' creates a comparator that compares students based on their grades.
		//'.reversed' reverses natural older of comparison, so it sorts it in descending order.
		Arrays.sort(course1Students, Comparator.comparingInt(Student::getGrade).reversed());
		Arrays.sort(course2Students, Comparator.comparingInt(Student::getGrade).reversed());
		Arrays.sort(course3Students, Comparator.comparingInt(Student::getGrade).reversed());
		
		//I'll need to implement sorting algorithm for arrays 
		
		//write sorted arrays to CSV files 
		CSVWriter csvWriter = new CSVWriter();
		csvWriter.writerCSV("course1.csv", course1Students);
		csvWriter.writerCSV("course2.csv", course2Students);
		csvWriter.writerCSV("course3.csv", course3Students);
	}
}