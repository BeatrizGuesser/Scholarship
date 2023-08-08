package beatriz.guesser.scholarship.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_instructor")
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_instructor;
    private String name_instructor;

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
}
