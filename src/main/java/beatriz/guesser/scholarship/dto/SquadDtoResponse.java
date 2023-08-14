package beatriz.guesser.scholarship.dto;

import beatriz.guesser.scholarship.entity.Student;

import java.util.List;

public class SquadDtoResponse {
    private Long id_squad;
    private String name_squad;

    private List<Student> students;


    public SquadDtoResponse() {
    }


    public SquadDtoResponse(Long id_squad, String name_squad, List<Student> students) {
        this.id_squad = id_squad;
        this.name_squad = name_squad;
        this.students = students;
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


    @Override
    public String toString() {
        return "SquadDtoResponse{" +
                "id_squad=" + id_squad +
                ", name_squad='" + name_squad + '\'' +
                ", students=" + students +
                '}';
    }
}
