package com.coderscampus;

//Represents a student with ID, name, course and grade.
//POJO

public class Student {
	
	private Integer id;
	private String name;
	private String course;
	private Integer grade;
	
	@Override
	public String toString() {
		return id + "," + name + "," + course + "," + grade; 
	}
	public Student(int id, String name, String course, int grade) { 
		this.id = id;
		this.name = name;
		this.course = course;
		this.grade = grade;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}

}
