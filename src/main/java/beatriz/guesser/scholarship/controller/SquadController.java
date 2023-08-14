package beatriz.guesser.scholarship.controller;

import beatriz.guesser.scholarship.dto.SquadDtoRequest;
import beatriz.guesser.scholarship.dto.SquadDtoResponse;
import beatriz.guesser.scholarship.service.SquadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/squads")
public class SquadController {
    @Autowired
    private SquadService squadService;

    @PostMapping("/post")
    public String postSquad(@RequestBody SquadDtoRequest squadDtoRequest) {
        squadService.save(squadDtoRequest);
        return "Squad successfully saved!";
    }
    @PutMapping("/add/{id_squad}/students/{id_student}")
    public String addStudentToSquad(@PathVariable Long id_squad, @PathVariable Long id_student){
        squadService.addStudentToSquad(id_squad, id_student);
        return "Student successfully added to squad!";
    }

    @GetMapping("/get/{id_squad}")
    public SquadDtoResponse getSquad(@PathVariable Long id_squad) {
        return squadService.getById(id_squad);
    }

    @DeleteMapping("/delete/{id_squad}")
    public String deleteSquad(@PathVariable Long id_squad) {
        squadService.delete(id_squad);
        return "Squad successfully deleted!";
    }
}
