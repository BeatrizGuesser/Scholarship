package beatriz.guesser.scholarship.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_class")
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_class;
    private String name_class;
    private String status_class;
    @ManyToOne
    @JoinColumn(name = "coordinator_id_coordinator")
    private Coordinator coordinator;
    @ManyToOne
    @JoinColumn(name = "scrum_id_scrum")
    private ScrumMaster scrumMaster;
    @ManyToMany(mappedBy = "classroom")
    private List<Instructor> instructors;
    @OneToMany(mappedBy = "classroom")
    private List<Student> students;

    public Classroom() {
    }

    public Classroom(Long id_class, Coordinator coordinator, ScrumMaster scrumMaster, List<Instructor> instructors) {
        this.id_class = id_class;
        this.coordinator = coordinator;
        this.scrumMaster = scrumMaster;
        this.instructors = instructors;
    }

    public Classroom(Long id_class, String name_class, String status_class) {
        this.id_class = id_class;
        this.name_class = name_class;
        this.status_class = status_class;
    }

    public Classroom(Long id_class, String name_class, String status_class, Coordinator coordinator, ScrumMaster scrumMaster, List<Instructor> instructors, List<Student> students) {
        this.id_class = id_class;
        this.name_class = name_class;
        this.status_class = status_class;
        this.coordinator = coordinator;
        this.scrumMaster = scrumMaster;
        this.instructors = instructors;
        this.students = students;
    }

    public Classroom(String name_class) {
        this.name_class = name_class;

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
