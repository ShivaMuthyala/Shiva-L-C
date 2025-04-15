package Collections;

import java.util.*;

public class StudentManager {
    private final List<Student> students = new ArrayList<>();
    private final Queue<String> counselingQueue = new LinkedList<>();

    public void addSampleStudents() {
    	students.add(new Student(1, "Ananya", "10A", Arrays.asList("Math", "Science")));
    	students.add(new Student(2, "Rohan", "10A", Arrays.asList("English", "Math")));
    	students.add(new Student(3, "Meera", "12B", Arrays.asList("Biology", "Chemistry")));
    	students.add(new Student(4, "Arjun", "12B", Arrays.asList("Physics", "Math")));
    	students.add(new Student(5, "Priya", "11C", Arrays.asList("History", "Geography")));
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public Map<String, List<Student>> groupByClass() {
        Map<String, List<Student>> classGroups = new HashMap<>();
        for (Student student : students) {
            String className = student.getClassName();
            if (!classGroups.containsKey(className)) {
                classGroups.put(className, new ArrayList<>());
            }
            classGroups.get(className).add(student);
        }
        return classGroups;
    }

    public Set<String> getAllUniqueSubjects() {
        Set<String> uniqueSubjects = new HashSet<>();
        for (Student student : students) {
            uniqueSubjects.addAll(student.getSubjects());
        }
        return uniqueSubjects;
    }

    public List<Student> searchStudentsBySubject(String subject) {
        List<Student> matchedSubjects = new ArrayList<>();
        for (Student student : students) {
            if (student.getSubjects().contains(subject)) {
                matchedSubjects.add(student);
            }
        }
        return matchedSubjects;
    }

    public void addToCounselingQueue(String studentName) {
        counselingQueue.add(studentName);
    }

    public Queue<String> getCounselingQueue() {
        return counselingQueue;
    }
}
