package com.coderscampus;

import java.util.Arrays;
import java.util.Comparator;

public class CourseManager {

	public static void main(String[] args) {
		CSVReader csvReader = new CSVReader();
		Student[] masterList = csvReader.readCSV("masterlist.csv");

		Student[] course1Students = new Student[34];
		Student[] course2Students = new Student[33];
		Student[] course3Students = new Student[33];

		Integer indexCourse1 = 0;
		Integer indexCourse2 = 0;
		Integer indexCourse3 = 0;

		for (Student student : masterList) {
			if (student != null) {
				String courseCode = student.getCourse().split(" ")[0];
				if ("COMPSCI".contains(courseCode)) {
					course1Students[indexCourse1] = student;
					indexCourse1++;
				} else if ("STAT".contains(courseCode)) {
					course2Students[indexCourse2] = student;
					indexCourse2++;
				} else if ("APMTH".contains(courseCode)) {
					course3Students[indexCourse3] = student;
					indexCourse3++;
				}
			}
		}

		Arrays.sort(course1Students, Comparator.comparingInt(Student::getGrade).reversed());
		Arrays.sort(course2Students, Comparator.comparingInt(Student::getGrade).reversed());
		Arrays.sort(course3Students, Comparator.comparingInt(Student::getGrade).reversed());

		CSVWriter csvWriter = new CSVWriter();
		csvWriter.writerCSV("course1.csv", course1Students);
		csvWriter.writerCSV("course2.csv", course2Students);
		csvWriter.writerCSV("course3.csv", course3Students);
	}
}


