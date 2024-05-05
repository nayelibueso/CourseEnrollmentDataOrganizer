package com.coderscampus;

import java.io.FileWriter;
import java.io.IOException;

//Modify to write a list of Student object to a CSV file.

public class CSVWriter {
	
	public void writerCSV(String fileName, Student [] students) { //name of CSV file to write to, data to be written to the file. 
		
		try (FileWriter fileWriter = new FileWriter (fileName)){ //try-with-resource block, automatically closes 'FileWriter' after the block is executed.
			fileWriter.write("Student ID, Student Name, Course, Grade\n");  //Write the header
			
			for (Student student : students) { //iterates over each 'Student' in 'student' array.
				fileWriter.write(student.toString() + "\n"); //For each student, convert to a string and write it to the CSV file. Each student is written on a new line. 
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
