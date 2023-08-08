package beatriz.guesser.scholarship.dto;

public class ScrumMasterDtoResponse {
    private Long id_scrum;
    private String name_scrum;

    public ScrumMasterDtoResponse(Long id_scrum, String name_scrum) {
        this.id_scrum = id_scrum;
        this.name_scrum = name_scrum;
    }

    public Long getId_scrum() {
        return id_scrum;
    }

    public void setId_scrum(Long id_scrum) {
        this.id_scrum = id_scrum;
    }

    public String getName_scrum() {
        return name_scrum;
    }

    public void setName_scrum(String name_scrum) {
        this.name_scrum = name_scrum;
    }
}
