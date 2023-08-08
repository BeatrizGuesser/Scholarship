package beatriz.guesser.scholarship.service;

import beatriz.guesser.scholarship.dto.InstructorDtoRequest;
import beatriz.guesser.scholarship.entity.Instructor;
import beatriz.guesser.scholarship.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorService {
    @Autowired
    private InstructorRepository instructorRepository;

    public void save(InstructorDtoRequest instructorDtoRequest){
        Instructor instructor = new Instructor(null, instructorDtoRequest.getName_instructor());
        instructorRepository.save(instructor);
    }
}
