package beatriz.guesser.scholarship.dto;

import beatriz.guesser.scholarship.entity.Coordinator;
import beatriz.guesser.scholarship.entity.Instructor;
import beatriz.guesser.scholarship.entity.ScrumMaster;
import beatriz.guesser.scholarship.entity.Student;

import java.util.List;

public class ClassroomDtoResponse {
    private Long id_class;
    private String name_class;
    private String status_class;
    private Coordinator coordinator;
    private ScrumMaster scrumMaster;
    private List<Instructor> instructors;
    private List<Student> students;

    public ClassroomDtoResponse() {
    }

    public ClassroomDtoResponse(Long id_class, String name_class, String status_class, Coordinator coordinator, ScrumMaster scrumMaster, List<Instructor> instructors, List<Student> students) {
        this.id_class = id_class;
        this.name_class = name_class;
        this.status_class = status_class;
        this.coordinator = coordinator;
        this.scrumMaster = scrumMaster;
        this.instructors = instructors;
        this.students = students;
    }

    public Long getId_class() {
        return id_class;
    }

    public void setId_class(Long id_class) {
        this.id_class = id_class;
    }

    public String getName_class() {
        return name_class;
    }

    public void setName_class(String name_class) {
        this.name_class = name_class;
    }

    public String getStatus_class() {
        return status_class;
    }

    public void setStatus_class(String status_class) {
        this.status_class = status_class;
    }

    public Coordinator getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(Coordinator coordinator) {
        this.coordinator = coordinator;
    }

    public ScrumMaster getScrumMaster() {
        return scrumMaster;
    }

    public void setScrumMaster(ScrumMaster scrumMaster) {
        this.scrumMaster = scrumMaster;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
