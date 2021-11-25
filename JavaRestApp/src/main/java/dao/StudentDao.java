package dao;

import domain.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentDao {

    private final Student.StudentBuilder cb = Student.builder();

    private final List<Student> students = new ArrayList<>(List.of(
            cb.firstName("Bram").surname("Janssens").email("s.a.janssens@gmail.com").id(1L).build(),
            cb.firstName("Joop").surname("Janssens").email("j.janssens@gmail.com").id(2L).build(),
            cb.firstName("Mieke").surname("Janssens").email("m.janssens@gmail.com").id(3L).build()
    ));

    public List<Student> getStudents() {
        return students;
    }

    public Optional<Student> getStudent(long id) {
        return students.stream() // 1) create a stream
                .filter(c -> c.getId() == id) // 2) bewerk de elementen in de stream
                .findAny();          // 3) reduce the stream
    }
}