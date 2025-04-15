package Collections;

import java.util.List;

public class Student {
	private int id;
	private String name;
	private String className;
	private List<String> subjects;

	Student(int id, String name, String className, List<String> subjects) {
		this.id = id;
		this.name = name;
		this.className = className;
		this.subjects = subjects;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getClassName() {
		return className;
	}

	public List<String> getSubjects() {
		return subjects;
	}

	@Override
	public String toString() {
		return "ID: " + id + ", Name: " + name + ", Class: " + className + ", Subjects: " + subjects;
	}

}
