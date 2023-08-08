package beatriz.guesser.scholarship.dto;

public class StudentDtoRequest {
    private String name_student;

    public StudentDtoRequest() {
    }

    public StudentDtoRequest(String name_student) {
        this.name_student = name_student;
    }

    public String getName_student() {
        return name_student;
    }

    public void setName_student(String name_student) {
        this.name_student = name_student;
    }
}
