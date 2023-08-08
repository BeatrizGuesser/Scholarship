package beatriz.guesser.scholarship.dto;

public class CoordinatorDtoRequest {
    private String name_coordinator;

    public CoordinatorDtoRequest() {
    }

    public CoordinatorDtoRequest(String name_coordinator) {
        this.name_coordinator = name_coordinator;
    }

    public String getName_coordinator() {
        return name_coordinator;
    }

    public void setName_coordinator(String name_coordinator) {
        this.name_coordinator = name_coordinator;
    }
}
