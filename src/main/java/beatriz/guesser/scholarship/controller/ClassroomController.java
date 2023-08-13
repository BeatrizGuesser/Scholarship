package beatriz.guesser.scholarship.controller;

import beatriz.guesser.scholarship.dto.ClassroomDtoRequest;
import beatriz.guesser.scholarship.dto.ClassroomDtoResponse;
import beatriz.guesser.scholarship.entity.Instructor;
import beatriz.guesser.scholarship.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


//    @PutMapping("/start/{id_class}/coordinators/{id_coordinator}/scrum-masters/{id_scrum}/instructor1/{id_instructor}/instructor2/{idInstructor}/instructor3/{instructor_id}")
//    public String startClass(@PathVariable Long id_class, @PathVariable Long id_coordinator, @PathVariable Long id_scrum, @PathVariable Long id_instructor, @PathVariable Long idInstructor, @PathVariable Long instructor_id){
//        classroomService.startClass(id_class, id_coordinator, id_scrum, id_instructor, idInstructor, instructor_id);
//        return "Class successfully started!";
//    }


    @GetMapping("/get/{id_class}")
    public ClassroomDtoResponse getClassroom(@PathVariable Long id_class) {
        return classroomService.getById(id_class);
    }

    @DeleteMapping("/delete/{id_class}")
    public String deleteClass(@PathVariable Long id_class) {
        classroomService.delete(id_class);
        return "Class successfully deleted!";
    }

    @PutMapping("/update/{id_class}")
    public String updateClassroom(@PathVariable Long id_class, @RequestBody ClassroomDtoRequest classroomDtoRequest) {
        classroomService.save(classroomDtoRequest);
        return "Class successfully updated!";
    }

    @PutMapping("/add/{id_class}/coordinators/{id_coordinator}")
    public String addCoordinatorToClass(@PathVariable Long id_class, @PathVariable Long id_coordinator){
        classroomService.addCoordinatorToClass(id_class, id_coordinator);
        return "Coordinator successfully added to classroom!";
    }

    @PutMapping("/add/{id_class}/scrum-masters/{id_scrum}")
    public String addScrumToClass(@PathVariable Long id_class, @PathVariable Long id_scrum){
        classroomService.addScrumToClass(id_class, id_scrum);
        return "Scrum Master successfully added to classroom!";
    }

}
