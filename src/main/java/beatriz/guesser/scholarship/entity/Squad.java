package beatriz.guesser.scholarship.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_squad")
public class Squad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_squad;
    private String name_squad;
    @OneToMany(mappedBy = "squad")
    private List<Student> students;

    public Squad() {
    }

    public Squad(Long id_squad, String name_squad, List<Student> students) {
        this.id_squad = id_squad;
        this.name_squad = name_squad;
        this.students = students;
    }

    public Squad(String name_squad) {
        this.name_squad = name_squad;
    }

    public Long getId_squad() {
        return id_squad;
    }

    public void setId_squad(Long id_squad) {
        this.id_squad = id_squad;
    }

    public String getName_squad() {
        return name_squad;
    }

    public void setName_squad(String name_squad) {
        this.name_squad = name_squad;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
