package beatriz.guesser.scholarship.service;

import beatriz.guesser.scholarship.dto.StudentDtoRequest;
import beatriz.guesser.scholarship.entity.Student;
import beatriz.guesser.scholarship.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {
    @Mock
    private StudentRepository studentRepository;
    @InjectMocks
    private StudentService studentService;

    @Test
    void save() {
        StudentDtoRequest studentDtoRequest = new StudentDtoRequest();
        studentDtoRequest.setName_student("Student 1");

        when(studentRepository.save(any(Student.class))).thenReturn(new Student(1L, "Student 1"));

        studentService.save(studentDtoRequest);

        verify(studentRepository).save(argThat(student -> student.getName_student().equals("Student 1")));
    }
}