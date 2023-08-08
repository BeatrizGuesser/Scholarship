package beatriz.guesser.scholarship.controller;

import beatriz.guesser.scholarship.dto.StudentDtoRequest;
import beatriz.guesser.scholarship.entity.Student;
import beatriz.guesser.scholarship.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/students")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/post")
    public String postStudent(@RequestBody StudentDtoRequest studentDtoRequest) {
        studentService.saveStudent(studentDtoRequest);
        return "Student successfully saved!";
    }

}
