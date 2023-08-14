package beatriz.guesser.scholarship.service;

import beatriz.guesser.scholarship.dto.ClassroomDtoRequest;
import beatriz.guesser.scholarship.dto.ClassroomDtoResponse;
import beatriz.guesser.scholarship.entity.*;
import beatriz.guesser.scholarship.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomService {
    @Autowired
    private ClassroomRepository classroomRepository;
    @Autowired
    private CoordinatorRepository coordinatorRepository;
    @Autowired
    private ScrumMasterRepository scrumMasterRepository;
    @Autowired
    private InstructorRepository instructorRepository;
    @Autowired
    private StudentRepository studentRepository;

    public void save(ClassroomDtoRequest classroomDtoRequest){
        Classroom classroom = new Classroom(classroomDtoRequest.getName_class());
        classroom.setStatus_class("Waiting");
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

    public void addCoordinatorToClass(Long id_class, Long id_coordinator) {
        Classroom classroom = classroomRepository.findById(id_class)
                .orElseThrow(() -> new RuntimeException("Classroom not found with id: " + id_class));

        Coordinator coordinator = coordinatorRepository.findById(id_coordinator)
                .orElseThrow(() -> new RuntimeException("Coordinator not found with id: " + id_coordinator));

            coordinator.addClassroom(classroom);
            classroom.setCoordinator(coordinator);
            coordinatorRepository.save(coordinator);
            classroomRepository.save(classroom);

    }

    public void addScrumToClass(Long id_class, Long id_scrum){
        Classroom classroom = classroomRepository.findById(id_class)
                .orElseThrow(() -> new RuntimeException("Classroom not found with id: " + id_class));

        ScrumMaster scrumMaster = scrumMasterRepository.findById(id_scrum)
                .orElseThrow(() -> new RuntimeException("Scrum Master not found with id: " + id_scrum));

        scrumMaster.addClassroom(classroom);
        classroom.setScrumMaster(scrumMaster);
        scrumMasterRepository.save(scrumMaster);
        classroomRepository.save(classroom);
    }

    public void addStudentToClass(Long id_class, Long id_student){
        Classroom classroom = classroomRepository.findById(id_class)
                .orElseThrow(() -> new RuntimeException("Classroom not found with id: " + id_class));

        Student student = studentRepository.findById(id_student)
                .orElseThrow(() -> new RuntimeException("Scrum Master not found with id: " + id_student));

        if (classroom.getStatus_class().equalsIgnoreCase("waiting")){
            student.setClassroom(classroom);
            classroom.setStudents(List.of(student));
            studentRepository.save(student);
            classroomRepository.save(classroom);
        }else {
            throw new RuntimeException("You can only register new students in the status WAITING");
        }

    }

    public void addInstructorToClass(Long id_class, Long id_instructor){
        Classroom classroom = classroomRepository.findById(id_class)
                .orElseThrow(() -> new RuntimeException("Classroom not found with id: " + id_class));

        Instructor instructor = instructorRepository.findById(id_instructor)
                .orElseThrow(() -> new RuntimeException("Instructor not found with id: " + id_instructor));


        instructor.addClassroom(classroom);
        classroom.setInstructors(List.of(instructor));
        instructorRepository.save(instructor);
        classroomRepository.save(classroom);
    }

    public void startClass(Long id_class){
        Classroom classroom = classroomRepository.findById(id_class).orElse(null);
        if(classroom.getInstructors().size() == 3 && classroom.getCoordinator() != null && classroom.getScrumMaster() != null){
            classroom.setStatus_class("Started");
            classroomRepository.save(classroom);
        }else {
            throw new RuntimeException("You need 1 coordinator, 1 scrum master and 3 instructors to start the class");
        }
    }

    public void finishClass(Long id_class){
        Classroom classroom = classroomRepository.findById(id_class).orElse(null);
        if(classroom.getInstructors().size() == 3 && classroom.getCoordinator() != null && classroom.getScrumMaster() != null && classroom.getStudents().size() >= 15 && classroom.getStudents().size() <= 30){
            classroom.setStatus_class("Finished");
            classroomRepository.save(classroom);
        }else {
            throw new RuntimeException("You need 1 coordinator, 1 scrum master, 3 instructors, minimum of 15 students and a maximum of 30 to finish the class");
        }
    }

}
