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
}
