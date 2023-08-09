package beatriz.guesser.scholarship.controller;

import beatriz.guesser.scholarship.dto.ClassroomDtoRequest;
import beatriz.guesser.scholarship.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/classes")
public class ClassroomController {
    @Autowired
    ClassService classService;

    @PostMapping("/post")
    public String postClass(@RequestBody ClassroomDtoRequest classroomDtoRequest) {
        classService.save(classroomDtoRequest);
        return "Class successfully saved!";
    }
}
