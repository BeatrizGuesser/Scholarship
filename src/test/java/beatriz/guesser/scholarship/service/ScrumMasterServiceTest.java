package beatriz.guesser.scholarship.service;

import beatriz.guesser.scholarship.dto.ScrumMasterDtoRequest;
import beatriz.guesser.scholarship.entity.ScrumMaster;
import beatriz.guesser.scholarship.repository.ScrumMasterRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ScrumMasterServiceTest {
    @Mock
    private ScrumMasterRepository scrumMasterRepository;
    @InjectMocks
    private ScrumMasterService scrumMasterService;

    @Test
    void save() {
        ScrumMasterDtoRequest scrumMasterDtoRequest = new ScrumMasterDtoRequest();
        scrumMasterDtoRequest.setName_scrum("Scrum Master 1");

        when(scrumMasterRepository.save(any(ScrumMaster.class))).thenReturn(new ScrumMaster(1L, "Scrum Master 1"));

        scrumMasterService.save(scrumMasterDtoRequest);

        verify(scrumMasterRepository).save(argThat(scrumMaster -> scrumMaster.getName_scrum().equals("Scrum Master 1")));
    }
}