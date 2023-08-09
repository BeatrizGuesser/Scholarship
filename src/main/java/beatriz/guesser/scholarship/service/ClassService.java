package beatriz.guesser.scholarship.service;

import beatriz.guesser.scholarship.dto.ClassroomDtoRequest;
import beatriz.guesser.scholarship.repository.ClassRepository;
import beatriz.guesser.scholarship.entity.Classroom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassService {
    @Autowired
    private ClassRepository classRepository;

    public void save(ClassroomDtoRequest classroomDtoRequest){
        Classroom classroom = new Classroom(null, classroomDtoRequest.getName_class(),
                classroomDtoRequest.getStatus_class(), classroomDtoRequest.getCoordinator(),
                classroomDtoRequest.getScrumMaster(), classroomDtoRequest.getInstructors(),
                classroomDtoRequest.getStudents());

        classRepository.save(classroom);
    }
}
