package beatriz.guesser.scholarship.controller;

import beatriz.guesser.scholarship.dto.ScrumMasterDtoRequest;
import beatriz.guesser.scholarship.service.ScrumMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scrum-masters")
public class ScrumMasterController  {
    @Autowired
    private ScrumMasterService scrumMasterService;

    @PostMapping("/post")
    public String postScrumMaster(@RequestBody ScrumMasterDtoRequest scrumMasterDtoRequest) {
        scrumMasterService.save(scrumMasterDtoRequest);
        return "Scrum Master successfully saved!";
    }
}
