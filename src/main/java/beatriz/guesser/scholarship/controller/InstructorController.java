package beatriz.guesser.scholarship.controller;


import beatriz.guesser.scholarship.dto.InstructorDtoRequest;
import beatriz.guesser.scholarship.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/instructors")
public class InstructorController {
    @Autowired
    private InstructorService instructorService;

    @PostMapping("/post")
    public String postInstructor(@RequestBody InstructorDtoRequest instructorDtoRequest) {
        instructorService.save(instructorDtoRequest);
        return "Car successfully saved!";
    }
}
