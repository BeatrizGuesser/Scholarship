package beatriz.guesser.scholarship.controller;

import beatriz.guesser.scholarship.entity.Squad;
import beatriz.guesser.scholarship.service.SquadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/squads")
public class SquadController {
    @Autowired
    private SquadService squadService;

    @GetMapping
    public List<Squad> getAllSquads() {
        return squadService.getAllSquads();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Squad> getSquadById(@PathVariable int id) {
        Squad squad = squadService.getSquadById(id);
        return squad != null ? ResponseEntity.ok(squad) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Squad createSquad(@RequestBody Squad squad) {
        return squadService.saveSquad(squad);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Squad> updateSquad(@PathVariable int id, @RequestBody Squad squadDetails) {
        Squad squad = squadService.getSquadById(id);
        if (squad != null) {
            squad.setName(squadDetails.getName());
            // Update other fields if needed
            squadService.saveSquad(squad);
            return ResponseEntity.ok(squad);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSquad(@PathVariable int id) {
        Squad squad = squadService.getSquadById(id);
        if (squad != null) {
            squadService.deleteSquad(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
