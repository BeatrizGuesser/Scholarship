package beatriz.guesser.scholarship.service;

import beatriz.guesser.scholarship.dto.ClassroomDtoResponse;
import beatriz.guesser.scholarship.dto.SquadDtoRequest;
import beatriz.guesser.scholarship.dto.SquadDtoResponse;
import beatriz.guesser.scholarship.entity.Classroom;
import beatriz.guesser.scholarship.entity.Squad;
import beatriz.guesser.scholarship.entity.Student;
import beatriz.guesser.scholarship.repository.SquadRepository;
import beatriz.guesser.scholarship.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public SquadDtoResponse getById(Long id_squad) {

        Squad squad = squadRepository.findById(id_squad).orElse(null);

        if (squad != null) {
            SquadDtoResponse squadDtoResponse = new SquadDtoResponse(squad.getId_squad(), squad.getName_squad(), squad.getStudents());

            return squadDtoResponse;
        } else {
            throw new RuntimeException("Id not found");
        }
    }

    public void delete(Long id_squad) {
        Squad squad = squadRepository.findById(id_squad)
                .orElseThrow(() -> new IllegalArgumentException("Classroom not found with ID: " + id_squad));

        squadRepository.delete(squad);
    }
}
