package beatriz.guesser.scholarship.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Coordinator coordinator;

    @ManyToOne
    private ScrumMaster scrumMaster;

    @OneToMany(mappedBy = "instructorClass")
    private List<Instructor> instructors;

    @OneToMany(mappedBy = "studentClass")
    private List<Student> students;
}
