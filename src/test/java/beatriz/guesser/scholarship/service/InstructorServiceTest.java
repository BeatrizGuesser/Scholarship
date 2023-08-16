package beatriz.guesser.scholarship.service;

import beatriz.guesser.scholarship.dto.InstructorDtoRequest;
import beatriz.guesser.scholarship.entity.Instructor;
import beatriz.guesser.scholarship.repository.InstructorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class InstructorServiceTest {
    @Mock
    private InstructorRepository instructorRepository;
    @InjectMocks
    private InstructorService instructorService;

    @Test
    void save() {
        InstructorDtoRequest instructorDtoRequest = new InstructorDtoRequest();
        instructorDtoRequest.setName_instructor("Instructor 1");

        when(instructorRepository.save(any(Instructor.class))).thenReturn(new Instructor(1L, "Instructor 1"));

        instructorService.save(instructorDtoRequest);

        verify(instructorRepository).save(argThat(instructor -> instructor.getName_instructor().equals("Instructor 1")));
    }
}