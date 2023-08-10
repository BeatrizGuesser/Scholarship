package beatriz.guesser.scholarship.service;

import beatriz.guesser.scholarship.dto.ClassroomDtoRequest;
import beatriz.guesser.scholarship.dto.ClassroomDtoResponse;
import beatriz.guesser.scholarship.repository.ClassroomRepository;
import beatriz.guesser.scholarship.entity.Classroom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassroomService {
    @Autowired
    private ClassroomRepository classroomRepository;

    public void save(ClassroomDtoRequest classroomDtoRequest){
        Classroom classroom = new Classroom(null, classroomDtoRequest.getName_class(),
                classroomDtoRequest.getStatus_class(), classroomDtoRequest.getCoordinator(),
                classroomDtoRequest.getScrumMaster(), classroomDtoRequest.getInstructors(),
                classroomDtoRequest.getStudents());

        classroomRepository.save(classroom);
    }

    public ClassroomDtoResponse getById(Long id_class) {

        Classroom classroom = classroomRepository.findById(id_class).orElse(null);

        if (classroom != null) {
            ClassroomDtoResponse classroomDtoResponse = new ClassroomDtoResponse(
                    classroom.getId_class(),
                    classroom.getName_class(),
                    classroom.getStatus_class(),
                    classroom.getCoordinator(),
                    classroom.getScrumMaster(),
                    classroom.getInstructors(),
                    classroom.getStudents());

            return classroomDtoResponse;
        } else {
            throw new IllegalArgumentException("Classroom not found with ID: " + id_class);
        }
    }

    public void delete(Long id_class) {
        Classroom classroom = classroomRepository.findById(id_class)
                .orElseThrow(() -> new IllegalArgumentException("Classroom not found with ID: " + id_class));

        classroomRepository.delete(classroom);
    }

}
