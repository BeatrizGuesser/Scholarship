package beatriz.guesser.scholarship.dto;

public class InstructorDtoResponse {
    private Long id_instructor;
    private String name_intructor;

    public InstructorDtoResponse(Long id_instructor, String name_intructor) {
        this.id_instructor = id_instructor;
        this.name_intructor = name_intructor;
    }

    public Long getId_instructor() {
        return id_instructor;
    }

    public void setId_instructor(Long id_instructor) {
        this.id_instructor = id_instructor;
    }

    public String getName_intructor() {
        return name_intructor;
    }

    public void setName_intructor(String name_intructor) {
        this.name_intructor = name_intructor;
    }
}
