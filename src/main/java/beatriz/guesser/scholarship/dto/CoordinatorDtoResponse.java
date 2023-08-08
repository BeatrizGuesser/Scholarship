package beatriz.guesser.scholarship.dto;

public class CoordinatorDtoResponse {
    private Long id_coordinator;
    private String name_coordinator;

    public CoordinatorDtoResponse(Long id_coordinator, String name_coordinator) {
        this.id_coordinator = id_coordinator;
        this.name_coordinator = name_coordinator;
    }

    public Long getId_coordinator() {
        return id_coordinator;
    }

    public void setId_coordinator(Long id_coordinator) {
        this.id_coordinator = id_coordinator;
    }

    public String getName_coordinator() {
        return name_coordinator;
    }

    public void setName_coordinator(String name_coordinator) {
        this.name_coordinator = name_coordinator;
    }
}
