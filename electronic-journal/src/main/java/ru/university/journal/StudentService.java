package ru.university.journal;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final List<Student> students = new ArrayList<>();
    private long nextId = 1;

    public Student addStudent(String fullName, String groupName) {
        Student student = new Student(
                nextId++,
                fullName,
                groupName
        );

        students.add(student);
        return student;
    }

    public List<Student> getAllStudents() {
        return List.copyOf(students);
    }

    public Student getStudentById(Long id) {
        return students.stream()
                .filter(student -> student.id().equals(id))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Студент не найден"
                        )
                );
    }

    public boolean deleteStudent(Long id) {
        return students.removeIf(student ->
                student.id().equals(id)
        );
    }
}