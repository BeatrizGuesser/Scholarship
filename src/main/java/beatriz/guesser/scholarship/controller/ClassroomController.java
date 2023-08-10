package beatriz.guesser.scholarship.controller;

import beatriz.guesser.scholarship.dto.ClassroomDtoRequest;
import beatriz.guesser.scholarship.dto.ClassroomDtoResponse;
import beatriz.guesser.scholarship.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/classes")
public class ClassroomController {
    @Autowired
    ClassroomService classroomService;

    @PostMapping("/post")
    public String postClass(@RequestBody ClassroomDtoRequest classroomDtoRequest) {
        classroomService.save(classroomDtoRequest);
        return "Class successfully saved!";
    }

    @GetMapping("/get/{id_class}")
    public ClassroomDtoResponse getClassroom(@PathVariable Long id_class) {
        return classroomService.getById(id_class);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteClass(@PathVariable Long id) {
        classroomService.delete(id);
        return "Class successfully deleted!";
    }

    @PutMapping("/update/{id_class}")
    public String updateClassroom(@PathVariable Long id_class, @RequestBody ClassroomDtoRequest classroomDtoRequest) {
        classroomService.save(classroomDtoRequest);
        return "Class successfully updated!";
    }
}
