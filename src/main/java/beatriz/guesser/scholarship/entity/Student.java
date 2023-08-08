package beatriz.guesser.scholarship.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_student;
    private String name_student;

    public Student() {
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
}
