package beatriz.guesser.scholarship.service;

import beatriz.guesser.scholarship.dto.CoordinatorDtoRequest;
import beatriz.guesser.scholarship.entity.Coordinator;
import beatriz.guesser.scholarship.repository.CoordinatorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CoordinatorServiceTest {
    @Mock
    private CoordinatorRepository coordinatorRepository;
    @InjectMocks
    private CoordinatorService coordinatorService;

    @Test
    void save() {
        CoordinatorDtoRequest coordinatorDtoRequest = new CoordinatorDtoRequest();
        coordinatorDtoRequest.setName_coordinator("Coordinator 1");

        when(coordinatorRepository.save(any(Coordinator.class))).thenReturn(new Coordinator(1L, "Coordinator 1"));

        coordinatorService.save(coordinatorDtoRequest);

        verify(coordinatorRepository).save(argThat(coordinator -> coordinator.getName_coordinator().equals("Coordinator 1")));

    }
}