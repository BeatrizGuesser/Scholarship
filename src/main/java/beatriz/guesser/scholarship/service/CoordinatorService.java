package beatriz.guesser.scholarship.service;

import beatriz.guesser.scholarship.dto.CoordinatorDtoRequest;
import beatriz.guesser.scholarship.entity.Coordinator;
import beatriz.guesser.scholarship.repository.CoordinatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoordinatorService {
    @Autowired
    private CoordinatorRepository coordinatorRepository;

    public void save(CoordinatorDtoRequest coordinatorDtoRequest) {
        Coordinator coordinator = new Coordinator(null, coordinatorDtoRequest.getName_coordinator());
        coordinatorRepository.save(coordinator);
    }

}
