package beatriz.guesser.scholarship.dto;

import beatriz.guesser.scholarship.entity.Coordinator;
import beatriz.guesser.scholarship.entity.Instructor;
import beatriz.guesser.scholarship.entity.ScrumMaster;
import beatriz.guesser.scholarship.entity.Student;

import java.util.List;

public class ClassroomDtoRequest {
    private String name_class;
    private String status_class;
    private Coordinator coordinator;
    private ScrumMaster scrumMaster;
    private List<Instructor> instructors;
    private List<Student> students;

    public ClassroomDtoRequest() {
    }

    public ClassroomDtoRequest(String name_class, String status_class, Coordinator coordinator, ScrumMaster scrumMaster, List<Instructor> instructors, List<Student> students) {
        this.name_class = name_class;
        this.status_class = status_class;
        this.coordinator = coordinator;
        this.scrumMaster = scrumMaster;
        this.instructors = instructors;
        this.students = students;
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
