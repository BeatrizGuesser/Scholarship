package beatriz.guesser.scholarship.controller;

import beatriz.guesser.scholarship.dto.InstructorDtoRequest;
import beatriz.guesser.scholarship.service.InstructorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(InstructorController.class)
class InstructorControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InstructorService instructorService;


    @Test
    void postInstructor() throws Exception {
        InstructorDtoRequest mockRequest = new InstructorDtoRequest(/* initialize fields */);

        mockMvc.perform(post("/v1/instructors/post")
                        .contentType("application/json")
                        .content(asJsonString(mockRequest)))
                .andExpect(status().isOk())
                .andExpect(content().string("Instructor successfully saved!"));

        verify(instructorService, times(1)).save(Mockito.any(InstructorDtoRequest.class));
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}