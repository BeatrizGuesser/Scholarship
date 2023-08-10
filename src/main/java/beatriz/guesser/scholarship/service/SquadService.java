package beatriz.guesser.scholarship.service;

import beatriz.guesser.scholarship.dto.SquadDtoRequest;
import beatriz.guesser.scholarship.entity.Squad;
import beatriz.guesser.scholarship.entity.Student;
import beatriz.guesser.scholarship.repository.SquadRepository;
import beatriz.guesser.scholarship.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SquadService {
    @Autowired
    private SquadRepository squadRepository;
    @Autowired
    private StudentRepository studentRepository;

    public void save(SquadDtoRequest squadDtoRequest){
        Squad squad = new Squad(squadDtoRequest.getName_squad());
        squadRepository.save(squad);
    }

    public void addStudentToSquad(Long id_squad, Long id_student) {
        Squad squad = squadRepository.findById(id_squad)
                .orElseThrow(() -> new RuntimeException("Squad not found with id: " + id_squad));

        Student student = studentRepository.findById(id_student)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id_student));

        if (squad.getStudents().size() <= 5) {
            student.setSquad(squad);
            studentRepository.save(student);
        } else {
            throw new RuntimeException("Squad is already full");
        }
    }
}
