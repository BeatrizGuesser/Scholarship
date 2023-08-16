package beatriz.guesser.scholarship.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_scrum")
public class ScrumMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_scrum;
    private String name_scrum;
    @JsonIgnore
    @OneToMany(mappedBy = "scrumMaster")
    private List<Classroom> classroom;

    public ScrumMaster() {
    }

    public ScrumMaster(Long id_scrum, String name_scrum) {
        this.id_scrum = id_scrum;
        this.name_scrum = name_scrum;
    }

    public Long getId_scrum() {
        return id_scrum;
    }

    public void setId_scrum(Long id_scrum) {
        this.id_scrum = id_scrum;
    }

    public String getName_scrum() {
        return name_scrum;
    }

    public void setName_scrum(String name_scrum) {
        this.name_scrum = name_scrum;
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
