package beatriz.guesser.scholarship.dto;

public class InstructorDtoResponse {
    private Long id_instructor;
    private String name_instructor;

    public InstructorDtoResponse(Long id_instructor, String name_instructor) {
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
