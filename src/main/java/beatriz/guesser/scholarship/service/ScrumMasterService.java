package beatriz.guesser.scholarship.service;

import beatriz.guesser.scholarship.dto.ScrumMasterDtoRequest;
import beatriz.guesser.scholarship.entity.ScrumMaster;
import beatriz.guesser.scholarship.repository.ScrumMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScrumMasterService {
    @Autowired
    private ScrumMasterRepository scrumMasterRepository;

    public void save(ScrumMasterDtoRequest scrumMasterDtoRequest){
        ScrumMaster scrumMaster = new ScrumMaster(null, scrumMasterDtoRequest.getName_scrum());
        scrumMasterRepository.save(scrumMaster);
    }
}
