package beatriz.guesser.scholarship.dto;

public class StudentDtoResponse {
    private Long id_student;
    private String name_student;

    public StudentDtoResponse() {
    }

    public StudentDtoResponse(Long id_student, String name_student) {
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
