package beatriz.guesser.scholarship.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_instructor")
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_instructor;
    private String name_instructor;
    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "instructor_classroom",
    joinColumns = @JoinColumn (name = "instructor_id_instructor"),
    inverseJoinColumns = @JoinColumn(name = "classroom_id_class"))
    private List<Classroom> classroom;

    public Instructor() {
    }

    public Instructor(Long id_instructor, String name_instructor) {
        this.id_instructor = id_instructor;
        this.name_instructor = name_instructor;
    }

    public Long getId_instructor() {
        return id_instructor;
    }

    public void setId_instructor(Long id_instructor) {
        this.id_instructor = id_instructor;
    }

    public String getName_instructor() {
        return name_instructor;
    }

    public void setName_instructor(String name_instructor) {
        this.name_instructor = name_instructor;
    }

    public List<Classroom> getClassroom() {
        return classroom;
    }

    public void setClassroom(List<Classroom> classroom) {
        this.classroom = classroom;
    }
    public void addClassroom(Classroom classroom){
        this.classroom.add(classroom);
    }
}
