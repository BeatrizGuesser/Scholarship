package beatriz.guesser.scholarship.service;


import beatriz.guesser.scholarship.dto.SquadDtoRequest;
import beatriz.guesser.scholarship.dto.SquadDtoResponse;
import beatriz.guesser.scholarship.entity.Squad;
import beatriz.guesser.scholarship.entity.Student;
import beatriz.guesser.scholarship.exception.IdNotFoundException;
import beatriz.guesser.scholarship.exception.NotAcceptable;
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

    public void save(SquadDtoRequest squadDtoRequest) {
        Squad squad = new Squad(squadDtoRequest.getName_squad());
        squadRepository.save(squad);
    }

    public void addStudentToSquad(Long id_squad, Long id_student) {
        Squad squad = squadRepository.findById(id_squad)
                .orElseThrow(() -> new IdNotFoundException("Squad not found with id: " + id_squad));

        Student student = studentRepository.findById(id_student)
                .orElseThrow(() -> new IdNotFoundException("Student not found with id: " + id_student));

        if (squad.getStudents().size() <= 5) {
            student.setSquad(squad);
            studentRepository.save(student);
        } else {
            throw new NotAcceptable("You can only have 5 students in each squad");
        }
    }

    public SquadDtoResponse getById(Long id_squad) {

        Squad squad = squadRepository.findById(id_squad)
                .orElseThrow(() -> new IdNotFoundException("Classroom not found with ID: " + id_squad));

        if (squad != null) {
            SquadDtoResponse squadDtoResponse = new SquadDtoResponse(squad.getId_squad(), squad.getName_squad(), squad.getStudents());

            return squadDtoResponse;
        } else {
            throw new NotAcceptable("Id not found");
        }
    }

    public void delete(Long id_squad) {
        Squad squad = squadRepository.findById(id_squad)
                .orElseThrow(() -> new IdNotFoundException("Classroom not found with ID: " + id_squad));

        squadRepository.delete(squad);
    }
}
