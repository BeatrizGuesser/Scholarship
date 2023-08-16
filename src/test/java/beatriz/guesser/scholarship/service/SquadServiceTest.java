package beatriz.guesser.scholarship.service;

import beatriz.guesser.scholarship.dto.SquadDtoRequest;
import beatriz.guesser.scholarship.dto.SquadDtoResponse;
import beatriz.guesser.scholarship.entity.Squad;
import beatriz.guesser.scholarship.entity.Student;
import beatriz.guesser.scholarship.repository.SquadRepository;
import beatriz.guesser.scholarship.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SquadServiceTest {
    @Mock
    private SquadRepository squadRepository;
    @Mock
    private StudentRepository studentRepository;
    @InjectMocks
    private SquadService squadService;

    @Test
    void save() {
        SquadDtoRequest squadDtoRequest = new SquadDtoRequest();
        squadDtoRequest.setName_squad("Test Squad");

        Squad savedSquad = new Squad(squadDtoRequest.getName_squad());
        when(squadRepository.save(any(Squad.class))).thenReturn(savedSquad);

        squadService.save(squadDtoRequest);

        verify(squadRepository).save(argThat(squad -> squad.getName_squad().equals("Test Squad")));
    }

    @Test
    void getById() {
        Squad squad = new Squad("Test Squad");
        when(squadRepository.findById(anyLong())).thenReturn(java.util.Optional.of(squad));

        SquadDtoResponse result = squadService.getById(1L);

        assertEquals("Test Squad", result.getName_squad());
    }

    @Test
    void delete() {
        Squad squad = new Squad("Test Squad");
        when(squadRepository.findById(anyLong())).thenReturn(java.util.Optional.of(squad));

        squadService.delete(1L);

        verify(squadRepository).delete(squad);
    }
}