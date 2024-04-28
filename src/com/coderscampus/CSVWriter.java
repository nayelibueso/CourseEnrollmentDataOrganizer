package com.coderscampus;

import java.io.FileWriter;
import java.io.IOException;

//Modify to write a list of Student object to a CSV file.

public class CSVWriter {
	
	public void writerCSV(String fileName, Student [] students) {
		
		try (FileWriter fileWriter = new FileWriter (fileName)){
			fileWriter.write("Student ID, Student Name, Course, Grade\n");  //Write the header
			
			for (Student student : students) {
				fileWriter.write(student.toString() + "\n");
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
