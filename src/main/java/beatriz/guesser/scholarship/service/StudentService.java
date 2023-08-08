package beatriz.guesser.scholarship.service;

import beatriz.guesser.scholarship.dto.StudentDtoRequest;
import beatriz.guesser.scholarship.entity.Student;
import beatriz.guesser.scholarship.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public void saveStudent(StudentDtoRequest studentDtoRequest){
        Student student = new Student(null, studentDtoRequest.getName_student());
        studentRepository.save(student);
    }
}
