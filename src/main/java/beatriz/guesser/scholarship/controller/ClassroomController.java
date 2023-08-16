package beatriz.guesser.scholarship.controller;

import beatriz.guesser.scholarship.dto.ClassroomDtoRequest;
import beatriz.guesser.scholarship.dto.ClassroomDtoResponse;
import beatriz.guesser.scholarship.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/v1/classes")
public class ClassroomController {
    @Autowired
    private ClassroomService classroomService;

    @PostMapping("/post")
    public String postClass(@RequestBody ClassroomDtoRequest classroomDtoRequest) {
        classroomService.save(classroomDtoRequest);
        return "Class successfully saved!";
    }


    @GetMapping("/get/{id_class}")
    public ClassroomDtoResponse getClassroom(@PathVariable Long id_class) {
        return classroomService.getById(id_class);
    }

    @DeleteMapping("/delete/{id_class}")
    public String deleteClass(@PathVariable Long id_class) {
        classroomService.delete(id_class);
        return "Class successfully deleted!";
    }

    @PutMapping("/add/{id_class}/coordinators/{id_coordinator}")
    public String addCoordinatorToClass(@PathVariable Long id_class, @PathVariable Long id_coordinator) {
        classroomService.addCoordinatorToClass(id_class, id_coordinator);
        return "Coordinator successfully added to classroom!";
    }

    @PutMapping("/add/{id_class}/scrum-masters/{id_scrum}")
    public String addScrumToClass(@PathVariable Long id_class, @PathVariable Long id_scrum) {
        classroomService.addScrumToClass(id_class, id_scrum);
        return "Scrum Master successfully added to classroom!";
    }

    @PutMapping("/add/{id_class}/students/{id_student}")
    public String addStudentToClass(@PathVariable Long id_class, @PathVariable Long id_student) {
        classroomService.addStudentToClass(id_class, id_student);
        return "Student successfully added to classroom!";
    }

    @PutMapping("/add/{id_class}/instructors/{id_instructor}")
    public String addInstructorToClass(@PathVariable Long id_class, @PathVariable Long id_instructor) {
        classroomService.addInstructorToClass(id_class, id_instructor);
        return "Instructor successfully added to classroom!";
    }

    @PutMapping("/start/{id_class}")
    public String startClass(@PathVariable Long id_class) {
        classroomService.startClass(id_class);
        return "Classroom started successfully!";
    }

    @PutMapping("/finish/{id_class}")
    public String finishClass(@PathVariable Long id_class) {
        classroomService.finishClass(id_class);
        return "Classroom finished successfully!";
    }
}
