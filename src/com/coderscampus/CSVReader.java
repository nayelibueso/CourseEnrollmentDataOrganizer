package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

//Modify to read the CSV file and dynamically manage arrays to store Student objects.

public class CSVReader {
	public Student[] readCSV(String fileName) {
		Student[] students = new Student[100]; // Initialize size of array
		Integer count = 0; // Counter for number of students read

		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) { //try-with-recources block, automatically closes the 'BufferedReader' after the block has been executed. 
			String line;
			br.readLine(); // skip header
			while ((line = br.readLine()) != null) { //Loop will continue until the end of the file.
				String[] parts = line.split(",");

				students[count] = new Student(Integer.parseInt(parts[0]), parts[1], parts[2],
						Integer.parseInt(parts[3])); //Line creates new 'Student' using the data parsed from the CSV line and store it in the 'student' array at the current 'count' index.
				count++;

				if (count == students.length) { //checks if the number of students read has reached the capacity of the 'students' array. If so, it doubles the size of the array to ensure space for additional students.
					students = Arrays.copyOf(students, students.length * 2);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		students = Arrays.copyOf(students, count); //line creates a new array containing only the actual number of students read and assigns it to the 'students' array. 
		return students;
	}

}
