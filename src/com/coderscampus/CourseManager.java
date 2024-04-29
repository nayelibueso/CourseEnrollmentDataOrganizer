package com.coderscampus;

//Main method, responsible for coordinating the reading, processing, sorting and writing of data. 

public class CourseManager {

	public static void main(String[] args) {
		CSVReader csvReader = new CSVReader();
		Student [] masterList = csvReader.readCSV("masterlist.csv");
		
		//count number of students in each class
		Integer countCourse1 = 34;
		Integer countCourse2 = 33;
		Integer countCourse3 = 33;
		
		for(Student student : masterList) { //This line starts a loop that iterates through each 'student' in the 'masterList' file.
			if (student != null) {//This checks if the current 'student' object is not null and is a valid student data.
				if ("COMPSCI".equals(student.getCourse())) { //If the students course is 'COMPSCI' we increment the countCourse1 variable by 1.
					countCourse1++;
				} else if ("STAT".equals(student.getCourse())) {
					countCourse2++;
				}else if ("APMTH".equals(student.getCourse())) {
					countCourse3++;
				}
			}
		}
		
		//create arrays for each course 
		Student [] course1Students = new Student[countCourse1];
		Student [] course2Students = new Student[countCourse2];
		Student [] course3Students = new Student[countCourse3];
		
		//Distribute student into the arrays based on their course 
		Integer indexCourse1 = 0;
		Integer indexCourse2 = 0;
		Integer indexCourse3 = 0;
		
		for (Student student : masterList) {
			if (student != null) {
				if( "COMPSCI".equals(student.getCourse())) {
					course1Students[indexCourse1++] = student;
				} else if("STAT".equals(student.getCourse())) {
					course2Students[indexCourse2++] = student;
				} else if ("APMTH".equals(student.getCourse())) {
					course3Students[indexCourse3++] = student;
				}
			}
		}
		
		//sort each array by grade in descending order
		//I'll need to implement sorting algorithm for arrays 
		
		//write sorted arrays to CSV files 
		CSVWriter csvWriter = new CSVWriter();
		
	}
}