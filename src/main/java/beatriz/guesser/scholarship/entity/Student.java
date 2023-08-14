package beatriz.guesser.scholarship.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_student;
    private String name_student;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "squad_id_squad")
    private Squad squad;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "classroom_id_class")
    private Classroom classroom;

    public Student() {
    }

    public Student(Long id_student, String name_student, Squad squad, Classroom classroom) {
        this.id_student = id_student;
        this.name_student = name_student;
        this.squad = squad;
        this.classroom = classroom;
    }

    public Student(Long id_student, String name_student) {
        this.id_student = id_student;
        this.name_student = name_student;
    }

    public Long getId_student() {
        return id_student;
    }

    public void setId_student(Long id_student) {
        this.id_student = id_student;
    }

    public String getName_student() {
        return name_student;
    }

    public void setName_student(String name_student) {
        this.name_student = name_student;
    }

    public Squad getSquad() {
        return squad;
    }

    public void setSquad(Squad squad) {
        this.squad = squad;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id_student=" + id_student +
                ", name_student='" + name_student + '\'' +
                ", squad=" + squad +
                ", classroom=" + classroom +
                '}';
    }
}
