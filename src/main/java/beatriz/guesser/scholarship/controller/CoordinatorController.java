package beatriz.guesser.scholarship.controller;

import beatriz.guesser.scholarship.dto.CoordinatorDtoRequest;
import beatriz.guesser.scholarship.service.CoordinatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/coordinators")
public class CoordinatorController {
    @Autowired
    private CoordinatorService coordinatorService;

    @PostMapping("/post")
    public String postCoordinator(@RequestBody CoordinatorDtoRequest coordinatoDtoRequest) {
        coordinatorService.save(coordinatoDtoRequest);
        return "Coordinator successfully saved!";
    }
}
