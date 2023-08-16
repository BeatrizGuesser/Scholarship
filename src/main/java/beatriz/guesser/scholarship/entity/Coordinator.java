package beatriz.guesser.scholarship.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_coordinator")
public class Coordinator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_coordinator;
    private String name_coordinator;
    @JsonIgnore
    @OneToMany(mappedBy = "coordinator")
    private List<Classroom> classroom;

    public Coordinator() {
    }

    public Coordinator(Long id_coordinator, String name_coordinator) {
        this.id_coordinator = id_coordinator;
        this.name_coordinator = name_coordinator;
    }

    public Long getId_coordinator() {
        return id_coordinator;
    }

    public void setId_coordinator(Long id_coordinator) {
        this.id_coordinator = id_coordinator;
    }

    public String getName_coordinator() {
        return name_coordinator;
    }

    public void setName_coordinator(String name_coordinator) {
        this.name_coordinator = name_coordinator;
    }

    public List<Classroom> getClassroom() {
        return classroom;
    }

    public void setClassroom(List<Classroom> classroom) {
        this.classroom = classroom;
    }

    public void addClassroom(Classroom classroom) {
        this.classroom.add(classroom);
    }

}
