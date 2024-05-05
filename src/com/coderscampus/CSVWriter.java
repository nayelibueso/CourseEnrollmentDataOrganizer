package com.coderscampus;

import java.io.FileWriter;
import java.io.IOException;

public class CSVWriter {

	public void writerCSV(String fileName, Student[] students) {

		try (FileWriter fileWriter = new FileWriter(fileName)) {
			fileWriter.write("Student ID, Student Name, Course, Grade\n");

			for (Student student : students) {
				if (student != null) {
					fileWriter.write(student.toString() + " \n");
				} else {
					System.out.println("Encountered null student.");
				}
			}
		}

		catch (IOException e) {
			e.printStackTrace();
		}

	}

}
