package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class CSVReader {
	public Student[] readCSV(String fileName) {
		Student[] students = new Student[100];
		Integer count = 0;

		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line;
			br.readLine();
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(",");

				students[count] = new Student(Integer.parseInt(parts[0]), parts[1], parts[2],
						Integer.parseInt(parts[3]));
				count++;

				if (count == students.length) {
					students = Arrays.copyOf(students, students.length * 2);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		students = Arrays.copyOf(students, count);
		return students;
	}

}
