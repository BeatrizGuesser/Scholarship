package beatriz.guesser.scholarship.controller;

import beatriz.guesser.scholarship.dto.SquadDtoRequest;
import beatriz.guesser.scholarship.dto.StudentDtoRequest;
import beatriz.guesser.scholarship.service.InstructorService;
import beatriz.guesser.scholarship.service.SquadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/squads")
public class SquadController {
    @Autowired
    private SquadService squadService;

    @PostMapping("/post")
    public String postSquad(@RequestBody SquadDtoRequest squadDtoRequest) {
        squadService.save(squadDtoRequest);
        return "Squad successfully saved!";
    }
    @PutMapping(value = "/squads/{id_squad}/students/{id_student}")
    public void addStudentToSquad(@PathVariable Long id_squad, @PathVariable Long id_student){
        squadService.addStudentToSquad(id_squad, id_student);
    }
}
