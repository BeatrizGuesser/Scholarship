package beatriz.guesser.scholarship.dto;

import beatriz.guesser.scholarship.entity.Student;

import java.util.List;

public class SquadDtoRequest {
    private String name_squad;

    private List<Student> students;

    public SquadDtoRequest() {
    }

    public SquadDtoRequest(String name_squad) {
        this.name_squad = name_squad;
    }

    public SquadDtoRequest(String name_squad, List<Student> students) {
        this.name_squad = name_squad;
        this.students = students;
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
